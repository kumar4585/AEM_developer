package com.hcl.aem.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.hcl.aem.core.beans.Links_Bean;

@Model(adaptables = Resource.class)
public class Cta_MultiLinks {
	@Inject
	public Resource pagePathMF;

	public List<Links_Bean> links = new ArrayList<Links_Bean>();

	@PostConstruct
	protected void init() {
		
			links = getPageList(links, pagePathMF);
		
	}

	public static List<Links_Bean> getPageList(List<Links_Bean> array, Resource resource) {
		if (resource != null) {

			Iterator<Resource> linkResource = resource.listChildren();
			while (linkResource.hasNext()) {
				Links_Bean lb = linkResource.next().adaptTo(Links_Bean.class);
               
				array.add(lb);

			}

		}
		return array;
	}

	public List<Links_Bean> getLinks() {
		return links;
	}

}
