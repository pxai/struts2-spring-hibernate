<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title><s:text name="title" /></title>
<s:head />
</head>
<body>
<s:div ><s:text name="hello" /></s:div>

<s:url action="formulario" var="enlaceAFormulario">
</s:url>
<a href="${enlaceAFormulario}">Ir al formulario</a> 

<s:property value="copyright" />


</body>
</html>