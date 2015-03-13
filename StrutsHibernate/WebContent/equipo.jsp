<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gesti�n equipos</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<h1><s:text name="teams" /></h1>
<s:form action="guardarOActualizarEquipo">
	<s:push value="equipo">
		<s:hidden name="id" />
		<s:textfield key="nombre" />
		<s:submit key="submit" />
	</s:push>
</s:form>

<s:if test="listaEquipos.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Id</th>
			<th>Nombre</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="listaEquipos" status="listaStatus">
			<tr
				class="<s:if test="#listaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="id" /></td>
				<td><s:property value="nombre" /></td>
				<td><s:url id="editURL" action="editarEquipo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="eliminarEquipo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>