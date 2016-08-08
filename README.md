spring-webservices-tutorial
==

Sample code that uses Spring 4.2.5, logback and a servlet 3.0 (no web.xml file). Built with Maven and includes Eclipse facets.
So it runs happily under the Eclipse Tomcat server.
Provides a web service endpoint, testable with SOAPUI.
Also does not need Spring Boot. I had problems with incompatibilities with Spring Boot and the Spring 4.2.5 and it should not be madndatory anyway.

Adapted from [http://briansjavablog.blogspot.co.nz/2013/01/spring-web-services-tutorial.html](http://briansjavablog.blogspot.co.nz/2013/01/spring-web-services-tutorial.html)

WSDL is at http://localhost:8080/spring-webservices-sample/endpoints/AccountDetailsService.wsdl

Changes from original code:
--

 * Upgrade to spring 4.2.5 & spring-ws-core 2.2.4
 * Use logback
 * change to @config (SpringWebConfig.java)
 * Use servlet 3.0 and eliminate web.xml file (see WebInitialiser.java)
 * Move the generated files to target/generated
 * wsdl is not generating correctly, can't build client (fixed, see comments in SpringWebConfig.java)
 
Proposed changes:
--
 * Add an attachment (actually two) to the request
 * Add an attachment to the response
  