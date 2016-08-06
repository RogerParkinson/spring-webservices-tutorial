spring-webservices-tutorial
==

Sample code that uses Spring 2.0.0, log4j and a servlet 2.5 web.xml file. Built with Maven and includes Eclipse facets.
So it runs happily under the Eclipse Tomcat server.
Provides a web service endpoint, testable with SOAPUI.

from [http://briansjavablog.blogspot.co.nz/2013/01/spring-web-services-tutorial.html](http://briansjavablog.blogspot.co.nz/2013/01/spring-web-services-tutorial.html)

WSDL is at http://localhost:8080/spring-webservices-sample/endpoints/AccountDetailsService.wsdl

TODO:
--

 * Upgrade to spring 4.2.5 & spring-ws-core 2.2.4 (done)
 * Use logback (done)
 * change to @config (done)
 * Use servlet 3.0 and eliminate web.xml file
 * Move the generated files to target/generated (done)
 * Add an attachment (actually two) to the request
 * Add an attachment to the response
  