<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title><s:text name="title" /></title>
<s:head />
</head>
<body>
<s:div ><s:text name="A calcular el IVA" /></s:div>


<s:form action="precio">

 	  <s:textfield key="precio" />
 	  <s:textfield  key="iva" />
 	           
   	  <s:submit key="submit" />
   	  
</s:form>


<s:property value="calcular" />


<s:property value="copyright" />


</body>
</html>