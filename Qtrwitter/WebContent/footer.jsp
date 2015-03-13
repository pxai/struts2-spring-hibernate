
	<div id="footer">
		<div>
			<a href="/Qtrwitter/signup.jsp" title="Sign up in Qtrwitter">Sign up</a>
		</div>
		<div>
			<a href="README.txt" title="Notas sobre este programa">README.txt</a>
		</div>
	<%
		if (null != session.getAttribute("login")) {
	%>
		<div>
			<a href="/Qtrwitter/logout" title="Logout">Logout</a>
		</div>
				
	<% 
		}
	%>
	</div>

<!-- cerramos div container -->
</div>

</body>
</html>