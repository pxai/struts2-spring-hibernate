<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba</title>
</head>
<body>
 
<s:form action="prueba">
    <s:textfield name="nombre" label="Nombre"/>
    <s:textfield name="id" label="id"/>
    <s:submit value="Dale"/>
</s:form>
 
</body>
</html>