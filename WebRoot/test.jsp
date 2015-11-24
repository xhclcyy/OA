<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">  
  
    <title>My JSP 'test.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<spring:url value="/js/jquery-1.11.3.min.js" var="jqueryJs" />
<script src="${jqueryJs}"></script>
	<spring:url value="/js/jquery.json.js" var="jqueryJson" />
<script src="${jqueryJson}"></script>

	<script>
	function userSubmit() {
		//alert("lau");
		var userform = $("#checkBOXForm");
		$.ajax({
			type : 'post',
			url : 'Tool!checkBox.action?' + userform.serialize(),
			data : {
				"laudukang" : "laudukang"
			},
			dataType : 'json',
			success : function(result) {
				//alert("dfd");
				alert("success" + JOSN.stringify(result));
				var t;
			},
			error : function(info) {
				alert("error=" + JOSN.stringify(info));
			}
		});
	}
	$(function() {
		$('#kaptchaImage').click(function() {
			$(this).attr('src', 'Kaptcha?' + Math.floor(Math.random() * 100));
		});
		
	});
</script>

  </head>
  
  <body>
    This is my JSP page. <br>
    
    <h3>Admin!login.action</h3>
	<form  method="post" id="checkBOXForm">
		<table>
			<tr>
				<td>loginUserName</td>
				<td><input type="text" name="loginUserName" /></td>
			</tr>
			<tr>
				<td>loginPassword</td>
				<td><input type="text" name="loginPassword" /> <br /></td>
			</tr>
			<tr>
				<td>verificationCode</td>
				<td><input type="text" name="verificationCode" /></td>
				<td><img id="kaptchaImage" name="kaptchaImage" src="Kaptcha"
					alt="验证码" /></td>
			</tr>
		</table>
		<input type="button" onclick="userSubmit()" value="提交" /> <br />

	</form>
	
  </body>
</html>
