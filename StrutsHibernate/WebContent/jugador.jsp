<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión jugador</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<h4>Insertar/modificar</h4>
<s:form action="guardarOActualizarJugador">
	<s:push value="jugador">
		<s:hidden name="id" />
		<s:textfield name="nombre" label="Nombre" />
		<s:textfield name="puesto" label="Puesto" />
		<s:textfield name="dorsal" label="Dorsal" />
<s:select label="Equipos"
       name="idequipo"
       list="equipos"
       listKey="id"
       listValue="nombre"
       multiple="false"
       required="true"
       value="idequipo"
/>
		<s:submit />
	</s:push>

</s:form>

<h4>Búsquedas</h4>
<s:form action="buscarJugador">
	<s:textfield name="nombre" label="nombre" />
	<s:submit />
</s:form>

<s:if test="listaJugadores.size() > 0">
	<div class="content">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Nombre</th>
			<th>Puesto</th>
			<th>Dorsal</th>
			<th>Id Equipo</th>
			<th>Nombre Equipo</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="listaJugadores" status="listaStatus">
			<tr
				class="<s:if test="#listaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="nombre" /></td>
				<td><s:property value="puesto" /></td>
				<td><s:property value="dorsal" /></td>
				<td><s:property value="equipo.id" /></td>
				<td><s:property value="equipo.nombre" /></td>
				<td><s:url id="editURL" action="editarJugador">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="eliminarJugador">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Eliminar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>