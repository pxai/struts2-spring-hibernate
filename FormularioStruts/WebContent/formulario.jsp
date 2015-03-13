<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Superformulario</title>
<s:head />
</head>
<body>
<s:form action="procesarformulario">

 	  <s:textfield name="nombre" label="Login" />
 	  <s:password  name="password" label="Password" />
 	  <s:textarea  name="descripcion" label="Descripción" />
 	  <s:radio name="sexo"  label="Sexo"  list="{'macho','macha','nose'}" />
	  <s:checkboxlist name="hobbies" label="Hobbies" list="{'vaguear','sillonbol','dormir'}" />
	  <s:hidden name="oculto" value="666" />
 	  <s:select name="estado" label="Estado civil" 
         list="#{'0':'Soltero','1':'Viudo','2':'Muerto'}" />

 	  <s:select name="equipos" label="Equipos preferidos" multiple="true" size="3"
         list="#{'0':'Recreativo de Juerga','1':'Rayo Vaticano','2':'Cádiz'}" />
         
   	  <s:submit/>
   	  
</s:form>

<s:property value="resultado" />


</body>
</html>