<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style><%@include file="../css/style.css"%></style>
<body>
<div align="center">
<div class="topnav" id="myTopnav">>
    <%@ include file="../fragments/header.jspf" %>
</div>
<p>Użytkownik ID: ${param.id} zaktualizowany pomyślnie</p>
</div>
<div id="footer">
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</div>
</body>
</html>