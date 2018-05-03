<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warsztat JEE + MySQL</title>
</head>
<style><%@include file="WEB-INF/css/style.css"%></style>
<body>
<div align="center">
<div class="topnav" id="myTopnav">
    <%@ include file="WEB-INF/fragments/header.jspf" %>
</div>
	<form action="/Workshop3/GroupEditServlet" method="post">

		Podaj nazwę grupy: <br><br> <input type="text" name="groupName" > <br><br>
		<input type="hidden" name="groupID" value="${param.groupID }" />
 		<input	type="submit">
	</form>
<br>
</div>
<div id="footer">
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</div>
</body>
</html>