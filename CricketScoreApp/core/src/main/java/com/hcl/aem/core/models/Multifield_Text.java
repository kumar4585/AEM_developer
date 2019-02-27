package com.hcl.aem.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class Multifield_Text {

	

	@Inject 
	private Resource MFText;

	public Resource getMFText() {
		return MFText;
	}
	

    @PostConstruct
    protected void init() {
	
    	
    	
    	
    }
}
