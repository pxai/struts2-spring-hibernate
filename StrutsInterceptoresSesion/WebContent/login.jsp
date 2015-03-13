<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
    <h3>Login</h3>
    <s:property value="saludo"/>

<s:form action="login"  method="post">
	<s:textfield key="name" />
	<s:password key="password" />
	<s:submit key="submit" />
</s:form>

<s:url id="url" action="hola" />
<a href="<s:property value="#url"/>">Ir a págin protegida por sesión</a>

</body>
</html>