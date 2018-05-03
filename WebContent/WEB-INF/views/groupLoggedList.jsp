<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warsztat JEE + MySQL</title>>
</head>
<style><%@include file="../css/style.css"%></style>
<body>
<div class="topnav" id="myTopnav">
    <%@ include file="../fragments/header.jspf" %>
</div>
<body>
<div  class="index" align="center">
<a href="addGroupForm.jsp">Dodaj grupę</a><br><a href="LogOutServlet">Wyloguj</a>
</div> <br><br>
<div align="center">
	<table id="mainTable" border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Edytuj grupę</th>
			<th>Usuń grupę</th>
		</tr>
		<c:forEach items="${groupList}" var="group">
			<tr>
				<td>${group.id}</td>
				<td>${group.name}</td>
				<td><a href="/Workshop3/groupEditForm.jsp?groupID=${group.id}">Edytuj</a></td>
				<td><a href="GroupDeleteServlet?groupID=${group.id}">Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
</div><br>
<div id="footer">
    <%@ include file="../fragments/footer.jspf" %>
</div>
</body>
</html>