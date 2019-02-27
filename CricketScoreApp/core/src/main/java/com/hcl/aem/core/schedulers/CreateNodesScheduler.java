package com.hcl.aem.core.schedulers;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.aem.core.schedulers.SimpleScheduledTask.Config;

@Designate(ocd=CreateNodesScheduler.Config.class)
@Component(service=Runnable.class)
public class CreateNodesScheduler  implements  Runnable{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String myParameter;
	  @ObjectClassDefinition(name="A scheduled task to Create Node",
              description = "Simple Node creation for cron-job like task with properties")

	 public static @interface Config {

	        @AttributeDefinition(name = "Cron-job expression")
	        String scheduler_expression() default "0 0/30 * ? * *";

	        @AttributeDefinition(name = "Concurrent task",
	                             description = "Whether or not to schedule this task concurrently")
	        boolean scheduler_concurrent() default false;

	        @AttributeDefinition(name = "A parameter",
	                             description = "Can be configured in /system/console/configMgr")
	        String myParameter() default "";
	    }

	  @Reference
		ResourceResolverFactory resolverFactory;
		ResourceResolver resourceResolver;
		Session session;
	  
		
		String nodePath = "/etc/CricketAppScheduler/";
		

	@Override
	public void run() {
		logger.info("Inside run Method");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(ResourceResolverFactory.SUBSERVICE, "kumar458");
		 logger.info("map obj created");
		
			try {
				resourceResolver = resolverFactory.getServiceResourceResolver(paramMap);
			
			 logger.info("rr created");
			session = resourceResolver.adaptTo(Session.class);

				logger.info("session created");

			Node root;
		
			if(nodePath != null)
			{
				logger.info("nodePath setup");
			root = session.getNode(nodePath);
		
		  	  Node adobe = root.addNode("adobe"); 
		  Node manager = adobe.addNode("manager"); 
		  manager.setProperty("message", "Adobe CQ message"); 
		  
		  
		  logger.info("node created");
			  	  session.save();	
			}		
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
	}
	
	 @Activate
	    protected void activate(final Config config) {
	        myParameter = config.myParameter();
	    }

	
}
/*

//Scr annotations not work after maven 10 archetype..build project below maven 10


import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.caconfig.annotation.Property;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Component(metatype = true, label = "A scheduled task to create node LH", 	description = "create node")
@Service
@Properties({ @Property(name = "scheduler.expression", value = "0 0/3 * ? * *", description = "Cron-job expression"),
	@Property(name = "scheduler.concurrent", boolValue = false, description = "Whether or not to schedule this task concurrently"),@Property(name = "scheduler.period", longValue = 600)})


public class CreateNodesScheduler  implements  Runnable{
	


	    private final Logger logger = LoggerFactory.getLogger(getClass());
	    @Reference
		ResourceResolverFactory resolverFactory;
		ResourceResolver resourceResolver;
		Session session;
		
		String nodePath = "/etc/kumar/";
		
			
		@Override
		public void run() {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put(ResourceResolverFactory.SUBSERVICE, "readService");
			 logger.info("map obj created");
			
				try {
					resourceResolver = resolverFactory.getServiceResourceResolver(paramMap);
				
				 logger.info("rr created");
				session = resourceResolver.adaptTo(Session.class);

					logger.info("session created");

				Node root;
			
				if(nodePath != null)
				{
					logger.info("nodePath setup");
				root = session.getNode(nodePath);
			
			  	  Node adobe = root.addNode("adobe"); 
			  Node manager = adobe.addNode("manager"); 
			  manager.setProperty("message", "Adobe CQ message"); 
			  
			  
			  logger.info("node created");
				  	  session.save();	
				}		
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	} 


	}


*/