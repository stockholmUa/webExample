package com.sourceit.webtasks.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sourceit.webtasks.WebtasksConstants;
import com.sourceit.webtasks.services.WebtasksServiceManager;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;



public class WebtasksContextListener implements ServletContextListener {
	private static final Logger LOGGER = Logger.getLogger(WebtasksContextListener.class);
	
	protected String getContext (ServletContextEvent sce) {
		String context = sce.getServletContext().getContextPath();
		return StringUtils.isBlank(context) ? "ROOT" : context;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String context = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute(WebtasksConstants.CONTEXT, context);
		
		WebtasksServiceManager.initialize(sce.getServletContext());
		WebtasksServiceManager.getInstance().startAllServices();
		
		LOGGER.info("Context '"+getContext(sce)+"' started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		WebtasksServiceManager webtasksServiceManager = WebtasksServiceManager.getInstance();
		webtasksServiceManager.closeAllServices();
		
		LOGGER.info("Context '"+getContext(sce)+"' stopped");
	}
}
