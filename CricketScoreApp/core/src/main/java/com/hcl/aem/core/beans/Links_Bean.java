package com.hcl.aem.core.beans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Links_Bean {

	@Inject@Optional
	private String pagePath;
	@Inject@Optional
    private String linkText;
	@PostConstruct
	protected String init() {
		pagePath = getPageURL(pagePath);
		return pagePath;
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

	public String getPagePath() {
		return pagePath;
	}

	public String getLinkText() {
		return linkText;
	}

	
}
