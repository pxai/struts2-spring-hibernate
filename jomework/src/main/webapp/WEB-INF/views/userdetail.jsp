<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Jomework :: User detail</title>
	</head> 
	<body>
		<header>User detail</header>
		<article><h2>User details: ${user.login}</h2></article>
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
				<li><b>Login</b>${user.login}</li> 
				<li><b>Password:</b>${user.password}</li>
				<li><b>Description</b>${user.description}</li>
			</ul>
	</body>
</html>

