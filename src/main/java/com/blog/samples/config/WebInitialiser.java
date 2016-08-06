package com.blog.samples.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class WebInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext container) {
		// Creates the root application context
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

		// Registers the application configuration with the root context
		appContext.register(SpringWebConfig.class);

		// Register and map the dispatcher servlet
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(appContext);
		messageDispatcherServlet.setTransformSchemaLocations(true);
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", messageDispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/endpoints/*");
		dispatcher.addMapping("*.wsdl");
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
}