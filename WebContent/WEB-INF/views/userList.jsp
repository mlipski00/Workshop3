<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Warsztat JEE + MySQL</title>
</head>
<style><%@include file="../css/style.css"%></style>
<body>
<div class="topnav" id="myTopnav">
    <%@ include file="../fragments/header.jspf" %>
</div>
<body>
<div align="center">
		<table id="mainTable" border=1>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			<th>Person_group_id</th>
			<th>Rozwiązania zadań</th>

		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.person_group_id}</td>
				<td><a href="/Workshop3/SolutionsByUserIdServlet?userID=${user.id}">Rozwiązania</a></td>
			</tr>
		</c:forEach>
	</table>
		<br>
</div>
<div id="footer">
    <%@ include file="../fragments/footer.jspf" %>
</div>
</body>
</html>