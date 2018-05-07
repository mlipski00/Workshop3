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
	<form action="/Workshop3/SolutionEditServlet" method="post">

		Edytujesz rozwiązanie ID: ${param.solutionID }<br><br>
		Podaj nowy opis rozwiązania: <br><br> <input type="text" name="solutionDescription" > <br><br>
		
		Wybierz do którego ćwiczenia ma być przypisane rozwiązanie:<br><br>
			  <select name="excercise">
			  <c:forEach items="${sessionScope.excerciseList}" var="excercise">
				<option value="${excercise.id }" >ID: ${excercise.id }. Nazwa: ${excercise.title }</option>
			</c:forEach>
			</select><br><br>
			<input type="hidden" name="solutionID" value="${param.solutionID }" /> <input type="submit">
		</form>
<br>
</div>
<div id="footer">
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</div>
</body>
</html>