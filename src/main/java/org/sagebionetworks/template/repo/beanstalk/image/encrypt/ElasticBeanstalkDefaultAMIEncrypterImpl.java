package org.sagebionetworks.template.repo.beanstalk.image.encrypt;

import static org.sagebionetworks.template.Constants.PROPERTY_KEY_ELASTICBEANSTALK_IMAGE_VERSION_AMAZONLINUX;
import static org.sagebionetworks.template.Constants.PROPERTY_KEY_ELASTICBEANSTALK_IMAGE_VERSION_JAVA;
import static org.sagebionetworks.template.Constants.PROPERTY_KEY_ELASTICBEANSTALK_IMAGE_VERSION_TOMCAT;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.CopyImageRequest;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalk;
import com.amazonaws.services.elasticbeanstalk.model.CustomAmi;
import com.amazonaws.services.elasticbeanstalk.model.DescribePlatformVersionRequest;
import com.amazonaws.services.elasticbeanstalk.model.ListPlatformVersionsRequest;
import com.amazonaws.services.elasticbeanstalk.model.PlatformDescription;
import com.amazonaws.services.elasticbeanstalk.model.PlatformFilter;
import com.amazonaws.services.elasticbeanstalk.model.PlatformSummary;
import com.google.inject.Inject;
import org.sagebionetworks.template.config.Configuration;
import org.sagebionetworks.template.config.RepoConfiguration;
import org.sagebionetworks.template.repo.beanstalk.BeanstalkUtils;

public class ElasticBeanstalkDefaultAMIEncrypterImpl implements ElasticBeanstalkDefaultAMIEncrypter {
	AWSElasticBeanstalk elasticBeanstalk;
	AmazonEC2 ec2;
	Configuration config;

	static final String AMI_VIRTUALIZATION_TYPE = "hvm";
	static final String SOURCE_AMI_TAG_KEY = "CopiedFrom";

	@Inject
	public ElasticBeanstalkDefaultAMIEncrypterImpl(AWSElasticBeanstalk elasticBeanstalk, AmazonEC2 ec2, RepoConfiguration config) {
		this.elasticBeanstalk = elasticBeanstalk;
		this.ec2 = ec2;
		this.config = config;
	}

	@Override
	public ElasticBeanstalkEncryptedPlatformInfo getEncryptedElasticBeanstalkAMI(String tomcatVersion, String javaVersion, String linuxVersion){
		//find the ARN of the platform from versions in the config
		String platformArn= getPlatformArn(
				javaVersion,
				tomcatVersion,
				linuxVersion);

		//use the platformArn to retrieve the platform's AMI image id
		PlatformDescription description = elasticBeanstalk.describePlatformVersion(
				new DescribePlatformVersionRequest().withPlatformArn(platformArn)
			).getPlatformDescription();

		String unencryptedDefaultAmiId = findDefaultPlatformAmiId(description);
		String encryptedAmiId = copyAndEncryptAmiIfNecessary(unencryptedDefaultAmiId);

		String solutionStackName = description.getSolutionStackName();
		return new ElasticBeanstalkEncryptedPlatformInfo(encryptedAmiId, solutionStackName);
	}


	String getPlatformArn(String javaVersion, String tomcatVersion, String amazonLinuxVersion) {
		// This can be null in buildListPlatformVersionsRequest so check here
		if(amazonLinuxVersion == null){
			throw new IllegalArgumentException("amazonLinuxVersion cannot be null");
		}
		List<PlatformSummary> platformSummaryList = elasticBeanstalk.listPlatformVersions(
				BeanstalkUtils.buildListPlatformVersionsRequest(javaVersion, tomcatVersion, amazonLinuxVersion)
		).getPlatformSummaryList();

		if(platformSummaryList == null || platformSummaryList.size() != 1){
			throw new IllegalArgumentException("There should only be 1 result matching your elastic beanstalk platform parameters");
		}

		return platformSummaryList.get(0).getPlatformArn();
	}

	String findDefaultPlatformAmiId(PlatformDescription description) {
		for (CustomAmi customAmi : description.getCustomAmiList()){
			if(AMI_VIRTUALIZATION_TYPE.equals(customAmi.getVirtualizationType())){
				return customAmi.getImageId();
			}
		}

		throw new IllegalArgumentException("Could not find an AMI Image Id for the given parameters");
	}

	String copyAndEncryptAmiIfNecessary(String defaultAMI) {
		//check if we've already copied and encrypted the image by checking tags
		DescribeImagesRequest describeImagesRequest = new DescribeImagesRequest()
				.withOwners("self")
				.withFilters(
						new Filter()
						.withName("tag:" + SOURCE_AMI_TAG_KEY)
						.withValues(defaultAMI));
		List<Image> images = ec2.describeImages(describeImagesRequest).getImages();

		//already been copied before because we got 1 result
		if(images.size() == 1) {
			return images.get(0).getImageId();
		}

		//copy the image and tag it so we can find it in the future and avoid recopying
		String encryptedCopyAmiId = ec2.copyImage(new CopyImageRequest().withEncrypted(true).withSourceImageId(defaultAMI).withSourceRegion(Regions.US_EAST_1.getName())).getImageId();
		ec2.createTags(new CreateTagsRequest()
				.withResources(encryptedCopyAmiId)
				.withTags(new Tag()
						.withKey(SOURCE_AMI_TAG_KEY)
						.withValue(defaultAMI)));
		return encryptedCopyAmiId;
	}

}
