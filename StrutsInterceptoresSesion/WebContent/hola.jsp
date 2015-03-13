<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
    <h3>Hola </h3>
    <s:property value="saludo"/>

<s:url id="url" action="login" />
<a href="<s:property value="#url"/>">Volver a login</a>


</body>
</html>