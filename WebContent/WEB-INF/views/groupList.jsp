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
			<th>Name</th>
		</tr>
		<c:forEach items="${groupList}" var="group">
			<tr>
				<td>${group.id}</td>
				<td>${group.name}</td>
			</tr>
		</c:forEach>
	</table>
		<br>
<div id="footer">
    <%@ include file="../fragments/footer.jspf" %>
</div>
</body>
</html>