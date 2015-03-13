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
	<h1><s:property value="main" /></h1>
	
	Message from action:
	<div>
		<s:property value="message" />
	</div>
	
	<div>
			<s:url id="selectAllURL" action="mainSelect">
			</s:url> 
			<s:a href="%{selectAllURL}">See all</s:a></td>
	</div>
	
	<s:if test="customers.size() > 0">
	<div class="content">
	<table  cellpadding="5px">
		<tr class="even">
			<th>id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
		</tr>
		<s:iterator value="customers" status="listaStatus">
			<tr
				class="<s:if test="#listaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="address" /></td>
				<td><s:property value="email" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
	

	
	<h3>Language</h3>
	<ul>
    <li>
        <s:url id="url" action="hello">
            <s:param name="request_locale">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url id="url" action="hello">
            <s:param name="request_locale">es</s:param>
        </s:url>
        <s:a href="%{url}">Español</s:a>
    </li>
</ul>
</body>
</html>