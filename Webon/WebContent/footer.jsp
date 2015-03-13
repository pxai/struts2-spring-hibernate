
	<div id="footer">
		<div>
			<a href="/Webon/signup.jsp" title="Sign up in Webon">Sign up</a>
		</div>
		<div>
			<a href="README.txt" title="Notas sobre este programa">README.txt</a>
		</div>
	<%
		if (null != session.getAttribute("login")) {
	%>
		<div>
			<a href="/Webon/logout" title="Logout">Logout</a>
		</div>
				
	<% 
		}
	%>
	</div>

<!-- cerramos div container -->
</div>

</body>
</html>