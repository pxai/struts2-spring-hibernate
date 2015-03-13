<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>User management : <spring:message code="update.user" text="Update user" var="userUpdate" /></title>
	</head> 
	<body>
		<header>
		<h1>${userUpdate}</h1>
			<nav>
				<%@ include file="UserNav.jsp" %>
			</nav>
		</header>
		<spring:url value="/user/saveupdate" var="urlupdate" />
		<form:form method="post" action="${urlupdate}" commandName="user">
		<form:hidden path="id" />
        <div>
        	<form:label path="name"><spring:message code="user.name" text="Name" /></form:label>
        	<form:errors path="name" />
        </div>
        <div><form:input path="name" /></div> 

        <div>
        	<form:label path="login"><spring:message code="user.login" text="user login" /></form:label>        	
        	<form:errors path="login" />
        </div>
        <div><form:input path="login" /></div>

        <div>
        	<form:label path="password"><spring:message code="user.password" text="Password" /></form:label>
        	<form:errors path="password" />
        </div>
        <div><form:input path="password" /></div>
        <div>
        	<form:label path="email"><spring:message code="user.email" text="email" /></form:label>
        	<form:errors path="email" />
        </div>
        <div><form:input path="email" /></div>
        <div>
        	<form:label path="since"><spring:message code="user.since" text="since" /></form:label>
        	<form:errors path="since" />
        </div>
        <div><form:input path="since" /></div>
        
        <div>
        	<form:label path="groupId"><spring:message code="user.groupId" text="groupId" /></form:label>
        	<form:errors path="groupId" />
        </div>
        <div><form:input path="groupId" /></div>
        
        <div>
            <input type="submit" value="${userUpdate}" />
        </div>
     
</form:form>
	</body>
</html>