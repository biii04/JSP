<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>구구단</h3>
<c:forEach begin="1" end="9" var="dan">
${dan }단<br/>
	<c:forEach begin="1" end="9" var="k">
	${dan }*${k}=${dan*k }
	</c:forEach>
</c:forEach>
</body>
</html>

