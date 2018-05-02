<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style><%@include file="../css/style.css"%></style>
<div id="header">
    <%@ include file="../fragments/header.jspf" %>
</div>
<div align="center">
<body>

	<table id="mainTable" border=1>
		<tr>
			<th>ID</th>
			<th>Created</th>
			<th>updated</th>
			<th>description</th>
			<th>excercise_id</th>
			<th>user_id</th>
		</tr>
		<c:forEach items="${solutionsList}" var="solution">
			<tr>
				<td>${solution.id}</td>
				<td>${solution.created}</td>
				<td>${solution.updated}</td>
				<td>${solution.description}</td>
				<td>${solution.excercise_id}</td>
				<td>${solution.user_id }</td>
				
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