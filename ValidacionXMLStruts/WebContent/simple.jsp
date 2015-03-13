<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Validación simple struts</title></head>
<body>
<s:text name="greet" />

<s:form action="simple"  method="post">
	<s:textfield key="name" />
	<s:password key="password1" />
	<s:password key="password2" />
	<s:textfield key="email" size="20" />
	<s:textfield key="cp" size="5" />
	<s:submit key="submit" />
</s:form>
<s:property value="saludo" />
</body>
</html>