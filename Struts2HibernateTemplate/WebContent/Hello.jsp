<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="welcome" /></title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
	<h1><s:property value="title" /></h1>
	
	Message from action:
	<div>
		<s:property value="message" />
	</div>
	<div>
			<s:url id="loginURL" action="login_input">
			</s:url> 
			<s:a href="%{loginURL}">Login</s:a></td>
	</div>
	
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