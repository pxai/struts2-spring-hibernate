<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Shipment management : new</title>
	</head> 
	<body>
		<header>
		<h1>New Shipment</h1>
			<nav>
				<%@include file="Nav.jsp" %>
			</nav>
		</header>

		<spring:url value="/shipment/save" var="urlsave" />
		<form:form method="post" action="${urlsave}" commandName="shipment">

        <div><form:label path="description">Description</form:label></div>
        <div><form:input path="description" /></div> 

        <div><form:label path="shipmentDate">Shipment Date</form:label></div>
        <div><form:input path="shipmentDate" /></div>

        <div><form:label path="origin">Origin</form:label></div>
        <div><form:input path="origin" /></div>

        <div><form:label path="destiny">Destiny</form:label></div>
        <div><form:input path="destiny" /></div>
        <div>
            <input type="submit" value="Add Shipment" />
        </div>
     
</form:form>
	</body>
</html>