<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Shipment management : <spring:message code="shipment.new" text="New Shipment" var="newShipment" /></title>
	</head> 
	<body>
		<header>
		<h1>${newShipment}</h1>
			<nav>
				<%@include file="Nav.jsp" %>
			</nav>
		</header>

		<spring:url value="/shipment/save" var="urlsave" />
		<form:form method="post" action="${urlsave}" commandName="shipment">

        <div>
        	<form:label path="description"><spring:message code="shipment.description" text="Description" /></form:label>
        	<form:errors path="description" />
        </div>
        <div><form:input path="description" /></div> 

        <div>
        	<form:label path="shipmentDate"><spring:message code="shipment.shipmentDate" text="Shipment Date" /></form:label>        	
        	<form:errors path="shipmentDate" />
        </div>
        <div><form:input path="shipmentDate" /></div>

        <div>
        	<form:label path="origin"><spring:message code="shipment.origin" text="Origin" /></form:label>
        	<form:errors path="origin" />
        </div>
        <div><form:input path="origin" /></div>

        <div>
        	<form:label path="destiny"><spring:message code="shipment.destiny" text="Destiny" /></form:label>
        	<form:errors path="destiny" />
        </div>
        <div><form:input path="destiny" /></div>
        
        <div>
            <input type="submit" value="${newShipment}" />
        </div>
     
</form:form>
	</body>
</html>