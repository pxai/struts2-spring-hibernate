<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Shipment management : see detail</title>
	</head> 
	<body>
		<header>
		<h1>Shipments</h1>
			<nav>
   				<%@include file="Nav.jsp" %>
			</nav>
		</header>
		<h2>Current shipment: ${shipment.id}</h2>
   			<div>
   				<div><b>Id:</b><c:out value="${shipment.id}"/> 
   					<a href="shipment/detail?id=<c:out value="${shipment.id}"/>">Detail</a> | 
   					<a href="shipment/update?id=<c:out value="${shipment.id}"/>">Update</a> | 
   					<a href="shipment/delete?id=<c:out value="${shipment.id}"/>">Delete</a>
   				</div>
   				<p><b>Description</b> <c:out value="${shipment.description}"/></p>
   				 <ul>
   				 	<li><b>Date</b> <c:out value="${shipment.shipmentDate}"/></li>
   				 	<li><b>Origin</b> <c:out value="${shipment.origin}"/></li>
   				 	<li><b>Destiny</b> <c:out value="${shipment.destiny}"/></li>
   				 </ul>
   			<div>

	</body>
</html>