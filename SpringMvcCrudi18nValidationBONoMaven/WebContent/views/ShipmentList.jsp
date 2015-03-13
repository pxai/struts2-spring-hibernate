<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title><spring:message code="shipment.management" />: see all</title>
	</head> 
	<body>
		<header>
		<h1><spring:message code="shipments" /></h1>
			<nav>
				<%@ include file="Nav.jsp" %>
			</nav>
		</header>
		<h2>Current shipments</h2>
		<c:forEach var="shipment" items="${shipments}">
   			<div>
   				<div><b>Id:</b><c:out value="${shipment.id}"/> 
   					<a href="<c:url value="/shipment/detail?id=${shipment.id}" />">Detail</a> | 
   					<a href="<c:url value="/shipment/update?id=${shipment.id}" />">Update</a> | 
   					<a href="<c:url value="/shipment/delete?id=${shipment.id}" />">Delete</a>
   				</div>
   				<p><b>Description</b> <c:out value="${shipment.description}"/></p>
   				 <ul>
   				 	<li><b>Date</b> <c:out value="${shipment.shipmentDate}"/></li>
   				 	<li><b>Origin</b> <c:out value="${shipment.origin}"/></li>
   				 	<li><b>Destiny</b> <c:out value="${shipment.destiny}"/></li>
   				 </ul>
   			<div>
		</c:forEach>
	</body>
</html>