<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jomework :: Users</title>
	</head> 
	<body>
		<header>Users</header>
		<article><h2>${greet}</h2></article>
		<nav>
			<ul>
				<li>
					<a href="<s:url value="/assignments" />" title="View Users">View assigments</a>
				</li>
				<li>
					<a href="<s:url value="/users/" />" title="View users">View users</a>
				</li>
				<li>
					<a href="<s:url value="/users/new" />" title="New user">New user</a>
				</li>
			</ul>
		</nav>

		<ul>		
		<c:forEach items="${users}"  var="user" >
				<li>
					<b>${user.login}</b> ${user.description}
					<a href="<s:url value="/users/detail?iduser=${user.id}" />" title="Detailed info"> see detail</a>
				</li>
		</c:forEach>
		</ul>
	</body>
</html>

