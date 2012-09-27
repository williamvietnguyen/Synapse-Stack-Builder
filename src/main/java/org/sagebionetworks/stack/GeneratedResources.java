package org.sagebionetworks.stack;

import java.net.URL;

import com.amazonaws.services.cloudsearch.model.DomainStatus;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazonaws.services.ec2.model.KeyPairInfo;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.elasticbeanstalk.model.ApplicationDescription;
import com.amazonaws.services.elasticbeanstalk.model.ApplicationVersionDescription;
import com.amazonaws.services.elasticbeanstalk.model.DescribeConfigurationOptionsResult;
import com.amazonaws.services.elasticbeanstalk.model.EnvironmentDescription;
import com.amazonaws.services.identitymanagement.model.ServerCertificateMetadata;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DBParameterGroup;
import com.amazonaws.services.rds.model.DBSecurityGroup;
import com.amazonaws.services.s3.model.Bucket;

/**
 * All of the resources generated by this build.
 * 
 * @author John
 *
 */
public class GeneratedResources {

	private String rdsAlertTopicArn;
	private SecurityGroup elasticBeanstalkEC2SecurityGroup;
	private DBSecurityGroup idGeneratorDatabaseSecurityGroup;
	private DBSecurityGroup stackInstancesDatabaseSecurityGroup;
	private DBInstance idGeneratorDatabase;
	private DBInstance stackInstancesDatabase;
	private DescribeAlarmsResult idGeneratorDatabaseAlarms;
	private DescribeAlarmsResult stackInstancesDatabaseAlarms;
	private URL stackConfigurationFileURL;
	private ApplicationDescription elasticBeanstalkApplication;
	private ApplicationVersionDescription portalApplicationVersion;
	private ApplicationVersionDescription searchApplicationVersion;
	private ApplicationVersionDescription repoApplicationVersion;
	private ApplicationVersionDescription authApplicationVersion;
	private ServerCertificateMetadata sslCertificate;
	private KeyPairInfo stackKeyPair;
	private DescribeConfigurationOptionsResult elasticBeanstalkConfigurationTemplate;
	private EnvironmentDescription authenticationEnvironment;
	private EnvironmentDescription repositoryEnvironment;
	private EnvironmentDescription searchEnvironment;
	private EnvironmentDescription portalEnvironment;
	private DomainStatus searchDomain;
	private DBParameterGroup dbParameterGroup;
	private Bucket mainFileBucket;

	/**
	 * The search domain.
	 * @return
	 */
	public DomainStatus getSearchDomain() {
		return searchDomain;
	}

	/**
	 * The search domain.
	 * @param searchDomain
	 */
	public void setSearchDomain(DomainStatus searchDomain) {
		this.searchDomain = searchDomain;
	}

	/**
	 * The authentication environment description.
	 * @return
	 */
	public EnvironmentDescription getAuthenticationEnvironment() {
		return authenticationEnvironment;
	}

	/**
	 * The authentication environment description.
	 * @param authenticationEnvironment
	 */
	public void setAuthenticationEnvironment(
			EnvironmentDescription authenticationEnvironment) {
		this.authenticationEnvironment = authenticationEnvironment;
	}

	/**
	 * The repository environment description.
	 * @return
	 */
	public EnvironmentDescription getRepositoryEnvironment() {
		return repositoryEnvironment;
	}

	/**
	 * The repository environment description.
	 * @param repositoryEnvironment
	 */
	public void setRepositoryEnvironment(
			EnvironmentDescription repositoryEnvironment) {
		this.repositoryEnvironment = repositoryEnvironment;
	}

	/**
	 * The repository environment description.
	 * @return
	 */
	public EnvironmentDescription getSearchEnvironment() {
		return searchEnvironment;
	}

	/**
	 * The repository environment description.
	 * @param repositoryEnvironment
	 */
	public void setSearchEnvironment(
			EnvironmentDescription searchEnvironment) {
		this.searchEnvironment = searchEnvironment;
	}

	
	/**
	 * The portal environment description.
	 * @return
	 */
	public EnvironmentDescription getPortalEnvironment() {
		return portalEnvironment;
	}

	/**
	 * The portal environment description.
	 * @param portalEnvironment
	 */
	public void setPortalEnvironment(EnvironmentDescription portalEnvironment) {
		this.portalEnvironment = portalEnvironment;
	}

	/**
	 * Elastic Beanstalk Configuration Template used to create environments.
	 * 
	 * @return
	 */
	public DescribeConfigurationOptionsResult getElasticBeanstalkConfigurationTemplate() {
		return elasticBeanstalkConfigurationTemplate;
	}

	/**
	 * Elastic Beanstalk Configuration Template used to create environments.
	 * 
	 * @param elasticBeanstalkConfigurationTemplate
	 */
	public void setElasticBeanstalkConfigurationTemplate(
			DescribeConfigurationOptionsResult elasticBeanstalkConfigurationTemplate) {
		this.elasticBeanstalkConfigurationTemplate = elasticBeanstalkConfigurationTemplate;
	}

	/**
	 * The Key Pair used by the stack.
	 * @return
	 */
	public KeyPairInfo getStackKeyPair() {
		return stackKeyPair;
	}

	/**
	 * The Key Pair used by the stack.
	 * @param stackKeyPair
	 */
	public void setStackKeyPair(KeyPairInfo stackKeyPair) {
		this.stackKeyPair = stackKeyPair;
	}

	/**
	 * The SSL certificate.
	 * @return
	 */
	public ServerCertificateMetadata getSslCertificate() {
		return sslCertificate;
	}

	/**
	 * The SSL certificate
	 * @param sslCertificate
	 */
	public void setSslCertificate(ServerCertificateMetadata sslCertificate) {
		this.sslCertificate = sslCertificate;
	}

	/**
	 * The elastic beanstalk application.
	 * @return
	 */
	public ApplicationDescription getElasticBeanstalkApplication() {
		return elasticBeanstalkApplication;
	}

	/**
	 * The elastic beanstalk application.
	 * @param elasticBeanstalkApplication
	 */
	public void setElasticBeanstalkApplication(
			ApplicationDescription elasticBeanstalkApplication) {
		this.elasticBeanstalkApplication = elasticBeanstalkApplication;
	}

	/**
	 * The application version of the portal.
	 * @return
	 */
	public ApplicationVersionDescription getPortalApplicationVersion() {
		return portalApplicationVersion;
	}

	/**
	 * The application version of the portal.
	 * @param portalApplicationVersion
	 */
	public void setPortalApplicationVersion(
			ApplicationVersionDescription portalApplicationVersion) {
		this.portalApplicationVersion = portalApplicationVersion;
	}

	/**
	 * The application version of the repository
	 * @return
	 */
	public ApplicationVersionDescription getRepoApplicationVersion() {
		return repoApplicationVersion;
	}

	/**
	 * 
	 * @param reopApplicationVersion
	 */
	public void setRepoApplicationVersion(
			ApplicationVersionDescription reopApplicationVersion) {
		this.repoApplicationVersion = reopApplicationVersion;
	}
	
	/**
	 * The application version of the repository
	 * @return
	 */
	public ApplicationVersionDescription getSearchApplicationVersion() {
		return searchApplicationVersion;
	}

	/**
	 * 
	 * @param reopApplicationVersion
	 */
	public void setSearchApplicationVersion(
			ApplicationVersionDescription searchApplication) {
		this.searchApplicationVersion = searchApplication;
	}

	/**
	 * The application version of the authentication service
	 * @return
	 */
	public ApplicationVersionDescription getAuthApplicationVersion() {
		return authApplicationVersion;
	}

	/**
	 * The application version of the authentication service
	 * @param authApplicationVersion
	 */
	public void setAuthApplicationVersion(
			ApplicationVersionDescription authApplicationVersion) {
		this.authApplicationVersion = authApplicationVersion;
	}

	/**
	 * The elastic beanstalk security group for this stack instance.
	 * @param group
	 */
	public void setElasticBeanstalkEC2SecurityGroup(SecurityGroup group) {
		this.elasticBeanstalkEC2SecurityGroup = group;
	}
	
	/**
	 * The elastic beanstalk security group for this stack instance.
	 * @return
	 */
	public SecurityGroup getElasticBeanstalkEC2SecurityGroup() {
		return elasticBeanstalkEC2SecurityGroup;
	}

	/**
	 * The topic used to notify when RDS alarms are triggered.
	 * @return
	 */
	public String getRdsAlertTopicArn() {
		return rdsAlertTopicArn;
	}

	/**
	 * The topic used to notify when RDS alarms are triggered.
	 * @param rdsAlertTopic
	 */
	public void setRdsAlertTopicArn(String rdsAlertTopicArn) {
		this.rdsAlertTopicArn = rdsAlertTopicArn;
	}

	/**
	 * The DB security group used by the Id Generator.
	 * @return
	 */
	public DBSecurityGroup getIdGeneratorDatabaseSecurityGroup() {
		return idGeneratorDatabaseSecurityGroup;
	}

	/**
	 * The DB security group used by the Id Generator.
	 * @param idGeneratorDatabaseSecurityGroup
	 */
	public void setIdGeneratorDatabaseSecurityGroup(
			DBSecurityGroup idGeneratorDatabaseSecurityGroup) {
		this.idGeneratorDatabaseSecurityGroup = idGeneratorDatabaseSecurityGroup;
	}

	/**
	 * The DB security group for the stack instances.
	 * @return
	 */
	public DBSecurityGroup getStackInstancesDatabaseSecurityGroup() {
		return stackInstancesDatabaseSecurityGroup;
	}

	/**
	 * The DB security group for the stack instances.
	 * @param stackInstancesDatabaseSecurityGroup
	 */
	public void setStackInstancesDatabaseSecurityGroup(
			DBSecurityGroup stackInstancesDatabaseSecurityGroup) {
		this.stackInstancesDatabaseSecurityGroup = stackInstancesDatabaseSecurityGroup;
	}

	/**
	 * The database instances used by the ID generator
	 * @return
	 */
	public DBInstance getIdGeneratorDatabase() {
		return idGeneratorDatabase;
	}

	/**
	 * The database instances used by the ID generator
	 * @param idGeneratorDatabase
	 */
	public void setIdGeneratorDatabase(DBInstance idGeneratorDatabase) {
		this.idGeneratorDatabase = idGeneratorDatabase;
	}

	/**
	 * The database instances used by the stack instance.
	 * @return
	 */
	public DBInstance getStackInstancesDatabase() {
		return stackInstancesDatabase;
	}

	/**
	 * The database instances used by the stack instance.
	 * @param stackInstancesDatabase
	 */
	public void setStackInstancesDatabase(DBInstance stackInstancesDatabase) {
		this.stackInstancesDatabase = stackInstancesDatabase;
	}

	/**
	 * The list of alarms applied to the ID Generator database.
	 * @return
	 */
	public DescribeAlarmsResult getIdGeneratorDatabaseAlarms() {
		return idGeneratorDatabaseAlarms;
	}

	/**
	 * The list of alarms applied to the ID Generator database.
	 * @param idGeneratorDatabaseAlarms
	 */
	public void setIdGeneratorDatabaseAlarms(DescribeAlarmsResult idGeneratorDatabaseAlarms) {
		this.idGeneratorDatabaseAlarms = idGeneratorDatabaseAlarms;
	}

	/**
	 * The list of Alarms applied to the stack instances database.
	 * @return
	 */
	public DescribeAlarmsResult getStackInstancesDatabaseAlarms() {
		return stackInstancesDatabaseAlarms;
	}

	/**
	 * The list of Alarms applied to the stack instances database.
	 * @param stackInstancesDatabaseAlarms
	 */
	public void setStackInstancesDatabaseAlarms(
			DescribeAlarmsResult stackInstancesDatabaseAlarms) {
		this.stackInstancesDatabaseAlarms = stackInstancesDatabaseAlarms;
	}

	/**
	 * The URL of the final stack configuration file generated by this build.
	 * @return
	 */
	public URL getStackConfigurationFileURL() {
		return stackConfigurationFileURL;
	}

	/**
	 * The URL of the final stack configuration file generated by this build.
	 * @param stackConfigurationFileURL
	 */
	public void setStackConfigurationFileURL(URL stackConfigurationFileURL) {
		this.stackConfigurationFileURL = stackConfigurationFileURL;
	}

	/**
	 * @return the dbParameterGroup
	 */
	public DBParameterGroup getDbParameterGroup() {
		return dbParameterGroup;
	}

	/**
	 * @param dbParameterGroup the dbParameterGroup to set
	 */
	public void setDbParameterGroup(DBParameterGroup dbParameterGroup) {
		this.dbParameterGroup = dbParameterGroup;
	}

	/**
	 * @return The S3 bucket to store files uploaded to the app.
	 */
	public Bucket getMainFileS3Bucket() {
		return mainFileBucket;
	}

	/**
	 * 
	 * @param mainFileBucket Set the S3 bucket to store files uploaded to the app.
	 */
	public void setMainFileS3Bucket(Bucket mainFileS3Bucket) {
		this.mainFileBucket = mainFileS3Bucket;
	}
}
