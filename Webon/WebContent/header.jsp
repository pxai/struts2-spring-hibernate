<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title>Aplicación Webon <%=config.getServletContext().getInitParameter("slogan") %></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="webon, webide, ide, gestor ficheros" />
<meta name="description" content="webon es un gestor de ficheros y un ide online" />
<meta name="author" content="Pello X" />

<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript" src="./js/common.js"></script>

</head>

<body>
<div id="container">
	<div id="logo">
		<a href="/Webon" title="Home">
			<img src="images/cutrelogo.png" alt="Webon Logo" title="Webon Logo" border="0" />
		</a>
	</div>
	<div>
		<a href="/Webon/signup.jsp" title="Sign up in Webon">Sign up</a>
		&nbsp;|&nbsp;
		<a href="/Webon/signin.jsp" title="Sign in in Webon">Sign in</a>
	</div>
