<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Mi primer jsp</title>
<script src="js/jquery.js"></script>
<script></script>
</head>
<body>
<%@ include file="cabecera.jsp" %>
<%
int i = 60;
int j = 9;
%>
<h1>Login</h1>

<%
	String mensajeError = "";
	if (null != request.getAttribute("error")) {
		mensajeError = request.getAttribute("error").toString();
	}
	
%>

<%=mensajeError%>

<form method="post" action="/Login/Alta">
				<fieldset>
				<legend>Entrar</legend>
				<label for="user">Usuario</label><br />
				<input type="text" name="user" id="user" /><br />
				
				<label for="pass">Password</label><br />
				<input type="password" name="pass" id="pass" /><br />
				
				<label for="pass2">Confirm</label><br />
				<input type="password" name="pass2" id="pass2"/>
				
				<input type="submit" name="boton" id="boton" value="Pínchame todo" />
				</fieldset>
			</form>
<%@ include file="pie.jsp" %>

</body>
</html>