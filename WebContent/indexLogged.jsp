<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
h1 {
	text-transform: uppercase;
	color: #4CAF50;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warsztat JEE + MySQL</title>
</head>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<body>
	<div class="topnav" id="myTopnav">
		<%@ include file="/WEB-INF/fragments/header.jspf"%>
	</div>
	<h1>Panel administracyjny </h1>
	<div  class="index" align="center">
	<a href="LogOutServlet">Wyloguj</a><br><br>
	<table id="mainTable" border=1 width="400">
		<tr>
			<th>Dostępne akcje:</th>
		</tr>
		<tr>
			<td><a href="UserLoggedServlet">Administracja użytkownikami</a></td>
		</tr>
		<tr>
			<td><a href="ExcerciseLoggedServlet">Administracja ćwiczeniami</a></td>
		</tr>
		<tr>
			<td><a href="GroupLoggedServlet">Administracja grupami użytkowników</a></td>
		</tr>
	</table>
	</div>
</body>
</html>