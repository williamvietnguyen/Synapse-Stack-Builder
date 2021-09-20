package org.sagebionetworks.template.docs;

import static org.sagebionetworks.template.Constants.PROPERTY_KEY_STACK;
import static org.sagebionetworks.template.Constants.PROPERTY_KEY_INSTANCE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import org.sagebionetworks.template.Constants;
import org.sagebionetworks.template.config.RepoConfiguration;
import org.sagebionetworks.template.s3.S3Config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.google.inject.Inject;

public class SynapseDocsBuilderImpl implements SynapseDocsBuilder {

	TransferManager transferManager;
	AmazonS3 s3Client;
	RepoConfiguration config;
	String instanceFileName;
	
	@Inject
	SynapseDocsBuilderImpl(AmazonS3 s3Client, S3Config s3Config, RepoConfiguration config) {
		this.s3Client = s3Client;
		transferManager = TransferManagerBuilder
				.standard()
				.withS3Client(s3Client)
				.build();
		instanceFileName = "instance.txt";
	}
	
	@Override
	public void deployDocs() {
		/*
		String stack = config.getProperty(PROPERTY_KEY_STACK);
		if (!stack.equals(Constants.PROD_STACK_NAME)) {
			return;
		}
		File instanceFile = new File("instance.txt");
		String prodInstance = config.getProperty(PROPERTY_KEY_INSTANCE);
		// to avoid deploying docs more than once for a given prod
		try {
			FileWriter writer = new FileWriter("instance.txt");
			if (instanceFile.createNewFile()) {
				// new file, we write the prod instance and continue
				writer.write(prodInstance);
			} else {
				Scanner scanner = new Scanner(instanceFile);
				if (scanner.hasNextInt()) {
					// if file's instance is greater than or equal to
					// prod instance, we are up to date on docs
					int instance = scanner.nextInt();
					if (instance >= Integer.parseInt(prodInstance)) {
						writer.close();
						scanner.close();
						return;
					}
				}
				scanner.close();
			}
			// overwrite file to the prod instance
			writer.write(prodInstance);
			writer.close();
		} catch (IOException e) {
		}
		*/
		System.out.println("note");
		String sourceBucket = "dev.release.rest.doc.sagebase.org";
		String prefix = "";
		String destinationBucket = "test.docs.bucket";
		ObjectListing sourceObjects = s3Client.listObjects(sourceBucket, prefix);
		Stream<S3ObjectSummary> destinationObjectsStream = s3Client.listObjects(destinationBucket, prefix)
				.getObjectSummaries()
				.stream();
		Set<String> destinationObjectKeySet = new HashSet<>();
		destinationObjectsStream.forEach(obj -> destinationObjectKeySet.add(obj.getKey()));
		for (S3ObjectSummary sourceObject : sourceObjects.getObjectSummaries()) {
			transferManager.copy(sourceBucket, sourceObject.getKey(), 
					destinationBucket, sourceObject.getKey());
		}
		for (String destinationObjectKey : destinationObjectKeySet) {
			s3Client.deleteObject(destinationBucket, destinationObjectKey);
		}
	}
}
