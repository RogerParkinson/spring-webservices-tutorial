package com.blog.samples.config;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;


@Configuration
@EnableWs
@ComponentScan({ "com.blog.samples.services" })
public class SpringWebConfig extends WsConfigurerAdapter {
	

//    private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    
	//    @Override
//    public void onStartup(ServletContext container) {
//      // Create the 'root' Spring application context
//      AnnotationConfigWebApplicationContext rootContext =
//        new AnnotationConfigWebApplicationContext();
//      rootContext.register(AppConfig.class);
//
//      // Manage the lifecycle of the root application context
//      container.addListener(new ContextLoaderListener(rootContext));
//
//      // Create the dispatcher servlet's Spring application context
//      AnnotationConfigWebApplicationContext dispatcherContext =
//        new AnnotationConfigWebApplicationContext();
//      dispatcherContext.register(DispatcherConfig.class);
//
//      // Register and map the dispatcher servlet
//      ServletRegistration.Dynamic dispatcher =
//        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//      dispatcher.setLoadOnStartup(1);
//      dispatcher.addMapping("/");
//    }

//    @Override
//	public void addInterceptors(List<EndpointInterceptor> interceptors) {
//		PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
//		validatingInterceptor.setXsdSchema(xsdSchema());
//		validatingInterceptor.setValidateRequest(true);
//		validatingInterceptor.setValidateResponse(true);
//		interceptors.add(validatingInterceptor);
//
//		interceptors.add(new PayloadLoggingInterceptor());
//	}
	// The bean name here has to match the PortTypeName
	@Bean(name="AccountDetailsService")
	public DefaultWsdl11Definition getWsdl() throws IOException {
		DefaultWsdl11Definition ret = new DefaultWsdl11Definition();
		ret.setSchema(xsdSchema());
		ret.setPortTypeName("AccountDetailsService");
		ret.setServiceName("AccountDetailsServices");
		ret.setLocationUri("/endpoints");
		return ret;
	}
	
	@Bean
	public SimpleXsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("AccountDetailsServiceOperations.xsd"));
	}
	
}
