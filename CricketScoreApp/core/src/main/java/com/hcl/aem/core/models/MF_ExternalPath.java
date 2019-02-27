package com.hcl.aem.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class MF_ExternalPath {

	@Inject 
	private Resource pagePathMF;
	@Inject 
	private String pagePath;

    @PostConstruct
    protected void init() {
       }

	public String getPagePath() {
		return pagePath;
	}


	public Resource getPagePathMF() {
		return pagePathMF;
	}
	
	
}
