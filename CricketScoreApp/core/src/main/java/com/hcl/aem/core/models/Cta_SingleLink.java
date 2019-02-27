package com.hcl.aem.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
@Model(adaptables=Resource.class)

public class Cta_SingleLink {
	
	@Inject
	private String link1;
	  @PostConstruct
	    protected void init() {
	        link1 = getPageURL(link1);
	        }
	  public static String getPageURL(String pagePath) {
	        if (pagePath.isEmpty() || (pagePath.equals(null))) {
	        return null;
	        } else if (pagePath.startsWith("/content")) {
	        return pagePath.concat(".html");
	        } else if (pagePath.startsWith("http://") || pagePath.startsWith("https://") || pagePath.startsWith("www")) {
	        return pagePath;
	        }
	        return pagePath;
	        }

public String getMessage() {
  return link1;
}
}
