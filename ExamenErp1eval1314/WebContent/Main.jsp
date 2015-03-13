<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="welcome" />: Main</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<div id="container">
<div id="header">
<h1>User & Role management: Main</h1>
</div>
<div id="content">
	<div>
		<s:property value="message" />
	</div>


<s:form action="selectRoles">
<s:select label="Roles"
       name="roleid"
       list="roles"
       listKey="id"
       listValue="name"
       multiple="false"
       required="true"
       value="roleid"
		/>
		<s:submit />
</s:form>


	
	<div>
			<s:url id="selectAllURL" action="mainSelect">
			</s:url> 
			<s:a href="%{selectAllURL}">See all</s:a></td>
	</div>
	
	<s:if test="users.size() > 0">

	<ul>
		<s:iterator value="users" status="listaStatus">
			<tr
				class="<s:if test="#listaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<li>
					<s:property value="login" />
					<s:url id="deleteURL" action="delete">
						<s:param name="id" value="id" />
					</s:url> 
					<s:a href="%{deleteURL}">Delete</s:a>
				</li>
		</s:iterator>
	</ul>
	</s:if>
	
</div>
<div id="footer">
User & Role management - &copy; Pello Xabier Altadill Izura
</div>
</div>

</body>
</html>