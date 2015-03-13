<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
		
		<sf:form method="post" modelAttribute="user">
			<fieldset><legend>New User</legend>			
				<label for="login">Login</label><br />
				<sf:input path="login"  /><br />
				<sf:errors path="login" cssClass="error" />
				<label for="password">Password</label><br />
				<sf:input path="password" /><br />
				<sf:errors path="password" cssClass="error" />
				<label for="description">Description</label><br />
				<sf:textarea  path="description" /><br />
				<sf:errors path="description" cssClass="error" />
				<input type="submit" name="create" value="Create" id="create" />
			</fieldset>
		</sf:form>

	</body>
</html>

