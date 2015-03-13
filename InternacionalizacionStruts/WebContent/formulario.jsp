<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title><s:text name="title" /></title>
<s:head />
</head>
<body>
<s:div ><s:text name="hello" /></s:div>
<s:div ><s:text name="greet" /></s:div>

<s:form action="formulario">

 	  <s:textfield key="name" />
 	  <s:password  key="password" />
 	  <s:textarea  key="description" />
         
   	  <s:submit key="submit" />
   	  
</s:form>

<s:property value="copyright" />


</body>
</html>