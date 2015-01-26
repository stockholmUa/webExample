package com.sourceit.webtasks.services;

import javax.servlet.ServletContext;


import com.sourceit.webtasks.services.implementation.EmailServiceImpl;
import com.sourceit.webtasks.services.mocks.DataServiceImpl;
import org.apache.log4j.Logger;


public final class WebtasksServiceManager {
	private static final Logger LOGGER = Logger.getLogger(WebtasksServiceManager.class);
	private static final String WEBTASKS_SERVICES_MANAGER = "WEBTASKS_SERVICES_MANAGER";
	
	private static WebtasksServiceManager INSTANCE;
	private final ServletContext servletContext;
	
	private WebtasksServiceManager (ServletContext context) {
		servletContext = context;
		init();
	}

	public static void initialize(ServletContext context) {
		WebtasksServiceManager instance = (WebtasksServiceManager) context.getAttribute(WEBTASKS_SERVICES_MANAGER);
		if(instance == null) {
			INSTANCE = new WebtasksServiceManager(context);
			context.setAttribute(WEBTASKS_SERVICES_MANAGER, INSTANCE);
		}
	}
	
	public static WebtasksServiceManager getInstance () {
		return (WebtasksServiceManager) INSTANCE.servletContext.getAttribute(WEBTASKS_SERVICES_MANAGER);
	}
	
	private DataService dataService;
	private EmailService emailService;
	
	public DataService getDataService() {
		return dataService;
	}
	
	public EmailService getEmailService() {
		return emailService;
	}
	
	private void init() {
		dataService = new DataServiceImpl();
		emailService = new EmailServiceImpl();
	}
	
	public void startAllServices(){
		LOGGER.info("All services have been started");
	}
	
	public void closeAllServices (){
		dataService.close();
		LOGGER.info("All services have been closed");
	}
}
