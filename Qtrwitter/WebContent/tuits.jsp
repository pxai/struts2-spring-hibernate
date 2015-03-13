
<%@ include file="header.jsp" %>
<% String username = request.getParameter("u"); %>
<h2>Tuits by: <%=username %></h2>

<jsp:useBean id="tuitList" scope="page"
 class="info.pello.servlets.qtrwitter.beans.TuitList" />
  <jsp:setProperty name="tuitList" property="datasource"
     value="<%=config.getServletContext().getInitParameter(\"datasource-name\")%>" />
 
 <%=tuitList.showTuits(username) %>
<%@ include file="footer.jsp" %>
