<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title>Aplicación Qtrwitter <%=config.getServletContext().getInitParameter("slogan") %></title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="qtrwitter, microblog, twits, redes sociales, fapfap" />
<meta name="description" content="qtrwitter el twitter cutre salchichero con el que me forraré" />
<meta name="author" content="Pello X" />

</head>

<body>
<div id="container">
	<div id="logo">
		<a href="/Qtrwitter" title="Home">
			<img src="images/qtrwitter.jpg" alt="Qtrwitter Logo" title="Qtrwitter Logo" border="0" />
		</a>
	</div>
	<div>
		<a href="/Qtrwitter/signup.jsp" title="Sign up in Qtrwitter">Sign up</a>
		&nbsp;|&nbsp;
		<a href="/Qtrwitter/signin.jsp" title="Sign in in Qtrwitter">Sign in</a>
	</div>
