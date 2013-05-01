<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<h2>Hello World!</h2>
	<pre>
Controller says: ${something}
Server info: <%= application.getServerInfo() %>  
Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>  
JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>  
Java version: <%= System.getProperty("java.version") %>

CONFIGURATION:
Environment Name: ${config.environmentName}
Root Url: ${config.rootUrl}
	</pre>
</body>
</html>
