<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="jstlResult.jsp">
Id : <input type="text" name="id"><br/>
Color : 
<select id="color">
	<option value="yellow">노랑</option>
	<option value="blue">파랑</option>
	<option value="orange">주황</option>
	<option value="pink">분홍</option>
	<option value="black">검정</option>
</select>

<input type = "submit" value = "button" name="보내기">
</form>
</body>
</html>