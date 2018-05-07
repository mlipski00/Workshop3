<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warsztat JEE + MySQL</title>
</head>
<style><%@include file="../css/style.css"%></style>
<div class="topnav" id="myTopnav">
    <%@ include file="../fragments/header.jspf" %>
</div>

<h1>Panel użytkownika </h1>
	<div  class="index" align="center">
	<a href="addSolutionForm.jsp">Dodaj ćwiczenie</a><br><a href="LogOutServlet">Wyloguj</a><br><br>
	</div>
<div align="center">
<body>

	<table id="mainTable" border=1>
		<tr>
			<th>ID</th>
			<th>Created</th>
			<th>Updated</th>
			<th>description</th>
			<th>Edytuj</th>
			<th>Usuń</th>
		</tr>
		<c:forEach items="${solutionsList}" var="solution">
			<tr>
				<td>${solution.id}</td>
				<td>${solution.created}</td>
				<td>${solution.updated}</td>
				<td>${solution.description}</td>
				<td><a href="/Workshop3/solutionEditForm.jsp?solutionID=${solution.id }">Edytuj rozwiązanie</a></td>
				<td><a href="/Workshop3/SolutionDeleteServlet?solutionID=${solution.id }">Usuń rozwiązanie</a></td>								
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