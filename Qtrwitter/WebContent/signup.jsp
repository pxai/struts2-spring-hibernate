<%@ include file="header.jsp" %>

<%=request.getAttribute("error") %>
<%
	request.setAttribute("error","");
%>
<form name="formulario" method="post" action="/Qtrwitter/SignUp">
<fieldset>
<legend>Alta en el Qtrwitter</legend>
<label for="login">Login</label><br />
<input type="text" name="login" id="login" value="" /><br />
<label for="password">Password</label><br />
<input type="password" name="password" id="password" value="" /><br />
<label for="password2">Repetir Password</label><br />
<input type="password" name="password2" id="password2" value="" /><br />
<label for="email">Email</label><br />
<input type="text" name="email" id="email" value="" size="20" /><br />
<input type="submit" name="enviar" id="enviar" value="Sign Up" /><br />
</fieldset>
</form>
<%@ include file="footer.jsp" %>