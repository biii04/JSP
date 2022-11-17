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
<h3>상세보기</h3>
<form action = "update.addr" method = "post">
<table>
<tr>
	<th>번호</th>
	<td><input type = "text" name = "num" value = "${address.num }"></td>
</tr>
<tr>
	<th>이름</th>
	<td><input type = "text" name = "name" value="${address.name }"></td>
</tr>

<tr>
	<th>우편번호</th>
	<td><input type = "text" name = "zipcode" id= "zipcode" value = "${address.zipcode }"></td>
	<td><input type="button" value ="검색" onclick="zipRead()"/></td>
</tr>

<tr>
	<th>주소</th>
	<td><input type = "text" name = "addr" id = "addr" value = "${address.addr }"></td>
</tr>

<tr>
	<th>전화번호</th>
	<td><input type = "text" name = "tel" value = "${address.tel }"></td>
</tr>

<tr>
	<th colspan = "2">
	<input type = "submit" value = "수정">
	<input type = "button" value = "삭제" onclick = "location.href = 'delete.addr?num=${address.num }'">
	<input type = "reset" value = "취소">
	<input type = "button" value="전체보기" onclick="location.href='list.addr'">
	<%--<button>전체보기</button> 얘는 기본적으로 submit form테그로 감쌌으니까 이 form테그가 수행하는 Jlist로 가는거 --%>
	</th>
</tr>	
</table>
</form>
</body>
</html>