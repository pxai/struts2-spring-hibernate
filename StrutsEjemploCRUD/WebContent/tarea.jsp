<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="guardarOActualizarTarea">
	<s:push value="tarea">
		<s:hidden name="id" />
		<s:textfield name="nombre" label="Nombre" />
		<s:textarea name="descripcion" label="Descripcion" />
		<s:textfield name="tipoTarea" label="TipoTarea" />

		<s:checkbox name="hecha"
			label="Tarea hecha?" />
		<s:submit />
	</s:push>
</s:form>

<s:if test="listaTareas.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Hecha</th>
			<th>TipoTarea</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="listaTareas" status="listaStatus">
			<tr
				class="<s:if test="#listaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="nombre" /></td>
				<td><s:property value="descripcion" /></td>
				<td><s:property value="hecha" /></td>
				<td><s:property value="tipoTarea" /></td>
				<td><s:url id="editURL" action="editarTarea">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="eliminarTarea">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>