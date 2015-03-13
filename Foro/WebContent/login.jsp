<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Estas hay que incluirlas en el lib del proyecto -->


  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Aplicación Foro</title>
</head>
<body>

<%=request.getAttribute("error") %>
<form name="formulario" method="post" action="/Foro/login">
<fieldset>
<legend>Login en el foro</legend>
<label for="login">Login</label><br />
<input type="text" name="login" id="login" value="" /><br />
<label for="password">Password</label><br />
<input type="password" name="password" id="password" value="" /><br />
<input type="submit" name="enviar" id="enviar" value="Login" /><br />
</fieldset>
</form>
<a href="/Foro/alta.jsp" title="Alta en el foro">Regístrate primo</a>
<hr />
<a href="LEEME.txt" title="Notas sobre este programa">LEEME.txt</a>
</body>
</html>