<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Login</title></head>
<body>
<s:form action="login">

 	  <s:textfield name="login" label="Login" />
 	  <s:password  name="password" label="Password" />
 	  
   	  <s:submit/>
   	  
</s:form>

<s:property value="resultado" />


</body>
</html>