
<%@ include file="header.jsp" %>
<%
String username = session.getAttribute("login").toString();
int iduser = Integer.parseInt(session.getAttribute("iduser").toString());
int idfile = Integer.parseInt(request.getParameter("idfile").toString());

// el directorio actual en principio será el home

%>
<%@ page import="info.pello.servlets.webon.beans.FileList,info.pello.servlets.webon.beans.File" %>

<%
	FileList fileList = new FileList();
	File file = fileList.getFile(idfile, iduser);
%>
 
<h2><%=username %> Update file <%=idfile %></h2>
<div>
	<div>
		<form name="formulario" method="post" action="/Webon/Admin">
		<fieldset>
		<legend>Update file</legend>
		
		<label for="name"><strong>Name *</strong></label><br />
		<input type="text" name="name" id="name" value="<%=file.getName() %>" /><br />
		<input type="hidden" name="idfile" id="idfile" value="<%=idfile%>" /><br />

		<label for="desc">Descripción</label><br />
		<textarea name="desc" id="desc" cols="20" rows="2" ><%=file.getDescription() %></textarea><br />
		<label for="text"><strong>Texto *</strong></label><br />
		<textarea name="text" id="text" cols="40" rows="10" ><%=file.getContent() %></textarea><br />
		<input type="submit" name="updatefile" id="updatefile" value="Update File" /><br />
		</fieldset>
		</form>
	</div>
</div>
<h2>Files by: <%=username %></h2>


<%@ include file="footer.jsp" %>
