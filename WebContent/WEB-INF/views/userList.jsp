<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jspf" %>
</div>
<body>
		<table border=1>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
			<th>Person_group_id</th>

		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.person_group_id}</td>
			</tr>
		</c:forEach>
	</table>
		<br>
<div id="footer">
    <%@ include file="../fragments/footer.jspf" %>
</div>
</body>
</html>