package com.shypovskikh.app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MyWebAppInitializer implements WebApplicationInitializer {

	

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		/*AnnotationConfigWebApplicationContext context 
		       =  new AnnotationConfigWebApplicationContext();
		 context.setConfigLocation("com.shypovskikh.app.config");
		 
		 container.addListener(new ContextLoaderListener(context));
		 
		 ServletRegistration.Dynamic dispatcher = container 
		      .addServlet("dispatcher", new DispatcherServlet(context));
		 dispatcher.setLoadOnStartup(1);
		 dispatcher.addMapping("/"); */
		 
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		
		ServletRegistration.Dynamic dispatcher  = container
				.addServlet("dispatcher", new DispatcherServlet(appContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/"); 
	}


}

























