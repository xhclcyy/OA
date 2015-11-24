<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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

<title>My JSP 'index.jsp' starting page</title>
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
	<div align="center">
		<div>---------------------登录------------------</div>
		<form method="post" action="login_login.do">
			账号：<input type="text" name="userAccount" /></br> 密码：<input type="password"
				name="password" /></br> 验证码：<input type="text" name="checkCode"><img
				src="Kaptcha.jpg" alt="验证码"></br> <input type="submit" name="确定" />
			<s:set name="hint" value="hint" />
			<s:if test='#hint=="1"'>
				<script type="text/javascript">
					var result = confirm("该账号已在其他地方登录，是否注销它");
					if (result) {
						location.href = "main.jsp";
					}
				</script>
			</s:if>
			<s:elseif test='#hint=="2"'>
				<script type="text/javascript">
					alert("你已经登录，请勿重复登录！")
				</script>
			</s:elseif>
			<s:else>
				<s:property value="hint" />
			</s:else>
		</form>
		<div>---------------------登出------------------</div>
		
		<form method="post" action="login_logout.do">
		<input type="hidden" name="userAccount" value="<%=session.getAttribute("userAccount") %>"/>
		<input type="submit" name="确定" />
		</form>
		<div>---------------------修改密码------------------</div>
		<form method="post" action="login_changePassword.do">
		<input type="hidden" name="userAccount" value="<%=session.getAttribute("userAccount") %>"/>
		 旧密码：<input type="password" name="password" /></br>
		 新密码：<input type="password" name="newPassword" /></br>
		 新密码：<input type="password" name="newPassword1" /></br>
		 <input type="submit" name="确定" />
		</form>
	</div>
</body>
</html>
