<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSTL사용</h3>
첫번째 수 : ${param.num1}<br>
두번째 수 : ${param.num2}<br>


<hr/>
결과 : ${param.num1+param.num2}
<c:set var="hap" value="${param.num1+param.num2}"/> 
<!-- '합'이라는 변수에 value값을 넣겠다 -->
hap : ${hap}<br/>
hap : <c:out value="${hap }"></c:out>


<!-- if문 -->
<c:if test="$hap%2==0">
짝수
</c:if>
<c:if test="$hap%2!=0">
홀수
</c:if>
<hr/>


<!-- switch-case문 -->
<c:choose>
	<c:when test="${hap%2==0 }">
	짝수
	</c:when>
	<c:when test="${hap%3==0 }">
	3의 배수
	</c:when>
	<c:otherwise>
	짝수도 3의 배수도 아니다
	</c:otherwise>
</c:choose>

</body>
</html>