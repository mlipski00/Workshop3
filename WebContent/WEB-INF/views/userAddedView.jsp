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
<body>
<div align="center">
<div class="topnav" id="myTopnav">>
    <%@ include file="../fragments/header.jspf" %>
</div>
      <c:if test = "${newID ne 0}">
      <p>Użytkownik dodany pomyślnie. ID: ${newID}</p>
      </c:if>
            <c:if test = "${newID == 0}">
      <p>Użytkownik o podanym adresie email istnieje już w bazie danych.</p>
      </c:if>

</div>
<div id="footer">
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</div>
</body>
</html>