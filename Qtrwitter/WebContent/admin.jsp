
<%@ include file="header.jsp" %>
<%
String username = session.getAttribute("login").toString();
%>
<h2><%=username %>My tuits</h2>
<form name="formulario" method="post" action="/Qtrwitter/Admin">
<fieldset>
<legend>Nuevo cutre tuit</legend>

<label for="text">Texto</label><br />
<textarea name="text" id="text" cols="40" rows="10" /></textarea><br />
<input type="submit" name="tuit" id="tuit" value="Tuit" /><br />
</fieldset>
</form>

<h2>Tuits by: <%=username %></h2>

<jsp:useBean id="tuitList" scope="page"
 class="info.pello.servlets.qtrwitter.beans.TuitList" />
 <jsp:setProperty name="tuitList" property="datasource"
     value="<%=config.getServletContext().getInitParameter(\"datasource-name\")%>" />
 
 <%=tuitList.showTuits(username) %>
<%@ include file="footer.jsp" %>
