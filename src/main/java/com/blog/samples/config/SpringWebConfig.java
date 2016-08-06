package com.blog.samples.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;


@Configuration
@EnableWs
@ComponentScan({ "com.blog.samples.services" })
public class SpringWebConfig extends WsConfigurerAdapter {
	

//    private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    
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
