<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>User management : see detail</title>
	</head> 
	<body>
		<header>
		<h1>User</h1>
			<nav>
   				<%@include file="UserNav.jsp" %>
			</nav>
		</header>
		<h2>Current user: ${user.id}</h2>
	<div>
   				<div><b>Id:</b><c:out value="${user.id}"/> 
   					<a href="<c:url value="/user/detail?id=${user.id}" />">Detail</a> | 
   					<a href="<c:url value="/user/update?id=${user.id}" />">Update</a> | 
   					<a href="<c:url value="/user/delete?id=${user.id}" />">Delete</a>
   				</div>
   				<p><b>Name</b> <c:out value="${user.name}"/></p>
   				 <ul>
   				 	<li><b>Login</b> <c:out value="${user.login}"/></li>
   				 	<li><b>Email</b> <c:out value="${user.email}"/></li>
   				 	<li><b>Since</b> <c:out value="${user.since}"/></li>
   				 </ul>
   			<div>

	</body>
</html>