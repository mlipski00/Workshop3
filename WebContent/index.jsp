<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
h1 {
	text-transform: uppercase;
	color: #4CAF50;
}
h2 {
	text-align: center;
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
	<h2>Zaloguj sie do panelu użytkownika lub panelu administracyjnego</h2>
	<div  class="index" align="center">
	<form action="/Workshop3/LoginServlet" method="post">
	Podaj login <input type="text" name="login"><br><br>
	Podaj hasło <input type="password" name="password"><br><br>
	<input type="submit">
	</form>
	</div>
</body>
</html>