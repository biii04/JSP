<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>Person</h3>
<body>
이름 : ${person.name }<%-- /<c:out value="${name }"/> --%><br>
나이 : ${person.age }<br>
성별 : ${person.gender }<br>
취미 : <c:forEach items="${person.hobby }" var="h">${h }</c:forEach><br>
직업 : ${person.job }


</body>
</html>