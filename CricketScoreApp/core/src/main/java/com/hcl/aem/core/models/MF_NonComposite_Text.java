package com.hcl.aem.core.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.commons.json.JSONObject;

import com.adobe.cq.sightly.WCMUsePojo;
import com.hcl.aem.core.beans.TextBean_NonComposite;

	@SuppressWarnings("deprecation")
	public class MF_NonComposite_Text extends WCMUsePojo {

		private List<TextBean_NonComposite> submenuItems = new ArrayList<TextBean_NonComposite>();

		@Override
		public void activate() throws Exception {
			setMultiFieldItems();
		}

	private List<TextBean_NonComposite> setMultiFieldItems() throws Exception {

	String[] itemsProps = getProperties().get("mfmenu", String[].class);
	 
	for (int i = 0; i < itemsProps.length; i++) {
	  
	JSONObject  jObj = new JSONObject(itemsProps[i]);
	  
	String title = jObj.getString("title1");
	String link = jObj.getString("path1");
	String flag = jObj.getString("flag1");
	 

	TextBean_NonComposite menuItem = new TextBean_NonComposite();

	menuItem.setTitle1(title);
	menuItem.setPath1(link);
	menuItem.setFlag1(flag);

	submenuItems.add(menuItem);
	}

	return submenuItems;
	}
	public List<TextBean_NonComposite> getMultiFieldItems() {
			return submenuItems;
		}
	}

