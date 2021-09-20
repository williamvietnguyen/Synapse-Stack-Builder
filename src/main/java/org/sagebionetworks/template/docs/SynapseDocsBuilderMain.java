package org.sagebionetworks.template.docs;

import org.sagebionetworks.template.TemplateGuiceModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SynapseDocsBuilderMain {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new TemplateGuiceModule());
		SynapseDocsBuilder builder = injector.getInstance(SynapseDocsBuilder.class);
		builder.deployDocs();
	}

}
