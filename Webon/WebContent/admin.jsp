<%@ include file="header.jsp" %>
<jsp:useBean id="fileList" scope="page"
 class="info.pello.servlets.webon.beans.FileList" />
 <%@ page import="info.pello.servlets.webon.beans.File" %>
 
<%
String username = session.getAttribute("login").toString();
// el directorio actual en principio será el home
int current_dir = Integer.parseInt(session.getAttribute("idhome").toString());
int iduser = Integer.parseInt(session.getAttribute("iduser").toString());

// Si nos pasan el parámetro dir y es mayor que 0
if (null != request.getParameter("dir") && Integer.parseInt(request.getParameter("dir")) >0) {
	current_dir = Integer.parseInt(request.getParameter("dir"));
}

File file = fileList.getFile(current_dir, iduser);

%>
<h2>My files in <%=file.getName() %></h2>
<div>
<a href="javascript:appearornot('newfilediv');isFile();" title="New file">New file</a>
<a href="javascript:isDir();appearornot('newfilediv');" title="New dir">New Dir</a>
	<div id="newfilediv">
		<form name="formulario" method="post" action="/Webon/Admin?dir=<%=current_dir %>">
		<fieldset>
		<legend>New file/dir</legend>
		
		<label for="name"><strong>Name *</strong></label><br />
		<input type="text" name="name" id="name" value="" /><br />
		<input type="hidden" name="idfather" id="idfather" value="<%=current_dir%>" /><br />
		<input type="hidden" name="idtype" id="idtype" value="2" /><br />

		<label for="desc">Descripción</label><br />
		<textarea name="desc" id="desc" cols="20" rows="2" ></textarea><br />
		<span id="spantext">
			<label for="text"><strong>Texto *</strong></label><br />
			<textarea name="text" id="text" cols="40" rows="10" ></textarea><br />
		</span>
		<input type="submit" name="newfile" id="newfile" value="New File" /><br />
		</fieldset>
		</form>
	</div>
</div>

<a href="/Webon/Admin" title="">Home</a> |
<a href="/Webon/Admin?dir=<%=file.getIdfather() %>" title="">Back</a>
 
 <%=fileList.showFiles(iduser, current_dir) %>
<%@ include file="footer.jsp" %>
