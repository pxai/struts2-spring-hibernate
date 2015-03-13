<%@ include file="header.jsp" %>

	<%=request.getAttribute("error") %>
	<%=request.getAttribute("msg") %>
	<%
		request.setAttribute("error","");
		request.setAttribute("msg","");
	%>
	<form name="formulario" method="post" action="/Qtrwitter/SignIn">
	<fieldset>
	<legend>Login en el Qtrwitter</legend>
	<label for="login">Login</label><br />
	<input type="text" name="login" id="login" value="" /><br />
	<label for="password">Password</label><br />
	<input type="password" name="password" id="password" value="" /><br />
	<input type="submit" name="enviar" id="enviar" value="Login" /><br />
	</fieldset>
	</form>
<%@ include file="footer.jsp" %>