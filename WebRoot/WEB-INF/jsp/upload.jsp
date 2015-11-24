<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h3>This is my upload test page.</h3>
	<br> now:
	<fmt:formatDate value="${now}" pattern="yyyy/MM/DD hh:mm:ss" />
	<br>
	<br>
	<form action="user/employeeUploadPic" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>test</td>
				<td><input type="text" name="test" id="test" /></td>
			</tr>
			<tr>
				<td>file</td>
				<td><input name="uploadFile" type="file" id="uploadFile" /></td>
			</tr>
		</table>
		<p id="buttons">
			<input id="reset" type="reset" tabindex="4"> <input
				id="submit" type="submit" tabindex="5" value="submit">
		</p>
	</form>
	<br>
	<br>
	<table>
		<tr>
			<td>succcess</td>
			<td><label>${success}</label></td>
		</tr>
		<tr>
			<td>message</td>
			<td><label>${message}</label></td>
		</tr>
	</table>
</body>
</html>
