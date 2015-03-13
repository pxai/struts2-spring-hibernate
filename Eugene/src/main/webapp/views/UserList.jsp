<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title><spring:message code="user.management" />: see all</title>
	</head> 
	<body>
		<header>
		<h1><spring:message code="users" /></h1>
			<nav>
				<%@ include file="UserNav.jsp" %>
			</nav>
		</header>
		<h2>Current users</h2>
		<table>
		<tr>
			<th><spring:message code="user.id" /></th>
			<th><spring:message code="user.name" /></th>
			<th><spring:message code="user.login" /></th>
			<th><spring:message code="user.password" /></th>
			<th><spring:message code="user.email" /></th>			
			<th><spring:message code="user.since" /></th>
			<th><spring:message code="user.groupId" /></th>
			<th><spring:message code="detail" /></th>
			<th><spring:message code="update" /></th>
			<th><spring:message code="delete" /></th>
		</tr>
		<c:forEach var="user" items="${users}">
   			<tr>
   				<td><c:out value="${user.id}"/></td> 
   				<td><c:out value="${user.name}"/></td>
   				<td><c:out value="${user.login}"/></td>
   				<td>****...</td>
   				<td><c:out value="${user.email}"/></td>
   				<td><c:out value="${user.since}"/></td>
   				<td><c:out value="${user.groupId}"/></td>
   				<td><a href="<c:url value="/user/detail?id=${user.id}" />"><spring:message code="detail" /></a></td> 
   				<td><a href="<c:url value="/user/update?id=${user.id}" />"><spring:message code="update" /></a></td>
   				<td><a href="<c:url value="/user/delete?id=${user.id}" />"><spring:message code="delete" /></a></td>
   			<tr>
		</c:forEach>
	</body>
</html>