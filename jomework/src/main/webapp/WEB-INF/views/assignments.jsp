<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jomework :: Assignments</title>
	</head> 
	<body>
		<header>Assignments</header>
		<article><h2>${greet}</h2></article>
		<nav>
			<ul>
				<li>
					<a href="assignments" title="View Assignments">View assigments</a>
				</li>
				<li>
					<a href="users" title="View users">View users</a>
				</li>
		</nav>
		
		<c:forEach items="${assignments}"  var="assignment" >
			<article>
				<div>${assignment.name}</div>
				<div>${assignment.description}</div>
			</article>
		</c:forEach>
	</body>
</html>

