<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,info.pello.servlets.foro.Foro,info.pello.servlets.foro.Mensaje" %>

<%
	int idpadre = (request.getParameter("idpadre").equals(""))?0:Integer.parseInt(request.getParameter("idpadre"));
	Foro foro = new Foro();
	ArrayList<Mensaje> mensajes = foro.getMessages(idpadre);
	String titulo = mensajes.get(0).getTitulo();
%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Aplicación Foro : foro <%=titulo%></title>
</head>
<body>
<h2>Foro: <%=titulo%></h2>
<table>

<%=request.getAttribute("error") %>
<form name="formulario" method="post" action="/Foro/hilo">
<fieldset>
<legend>Nuevo tema en el foro</legend>
<input type="hidden" name="idpadre" id="idpadre" value="<%=idpadre%>" /><br />
<label for="titulo">Título</label><br />
<input type="text" name="titulo" id="titulo" value="" /><br />
<label for="texto">Texto</label><br />
<textarea name="texto" id="texto" cols="40" rows="10" /></textarea><br />
<input type="submit" name="enviar" id="enviar" value="Publicar" /><br />
</fieldset>
</form>
<a href="/Foro/alta.jsp" title="Alta en el foro">Regístrate primo</a>
<%
	HttpSession sesion = request.getSession();
	int idusuario = Integer.parseInt(sesion.getAttribute("idusuario").toString());

		String urltema = "";
		for (int i=0;i<mensajes.size();i++) {
			out.println("<tr>");
			out.println("<td colspan='2'><h3>"+mensajes.get(i).getTitulo()+"</h3></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+mensajes.get(i).getAutor()+"</td>");
			out.println("<td>"+mensajes.get(i).getFecha().toString()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan='2'>"+mensajes.get(i).getTexto()+"</a></td>");
			out.println("</tr>");
		}
		
%>
</table>
</body>
</html>