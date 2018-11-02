<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th><th>姓名</th><th>手机号</th><th>锁定</th>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.phone }</td>
			<td>${user.isLock }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>