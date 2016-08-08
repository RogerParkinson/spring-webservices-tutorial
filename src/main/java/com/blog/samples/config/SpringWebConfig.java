package com.blog.samples.config;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;


@Configuration
@EnableWs
@ComponentScan({ "com.blog.samples.services" })
public class SpringWebConfig extends WsConfigurerAdapter {
	
	@Autowired
	private ServletContext context;
//    private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    
	// The bean name here has to match the PortTypeName
	@Bean(name="AccountDetailsService")
	public DefaultWsdl11Definition getWsdl() throws IOException {
		DefaultWsdl11Definition ret = new DefaultWsdl11Definition();
		ret.setSchemaCollection(xsdSchema());
		ret.setPortTypeName("AccountDetailsService");
		ret.setServiceName("AccountDetailsServices");
		ret.setLocationUri("/endpoints");
		return ret;
	}
	
	/**
	 * This bean defines the schema for the wsdl generation. There are actually two schema files and this one imports the second one.
	 * It seems to do the resolution at bean definition time rather than on request because there is only one http request logged.
	 * Note that using classpath fails to resolve the imported xsd and generates a bad wsdl.
	 * 
	 * @return CommonsXsdSchemaCollection
	 */
	@Bean
	public CommonsXsdSchemaCollection xsdSchema() {
		CommonsXsdSchemaCollection ret = new CommonsXsdSchemaCollection();
		ret.setInline(true);
		ret.setXsds(new Resource[]{new ServletContextResource(context,"schemas/AccountDetailsServiceOperations.xsd")});
		return ret;
	}
	
}
