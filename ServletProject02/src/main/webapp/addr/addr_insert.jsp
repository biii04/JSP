<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet</title>
<script>
	function zipfinder(){
		window.open("zip.addr","","width=700 height=400"); //메시지 창(새창) 띄우기/ 창 크기
	}
</script>
</head>
<body>
<a href="addrList">전체보기</a><br/>  <%-- 얘는 method="get" --%>
<form action="insert.addr" method="post">
<table border="1">
		<tr>
				<td colspan="2">Servlet</td>
		</tr>
		<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
		</tr>
		<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" id="zipcode" size=5>
					<input type="button" value="검색" onclick="zipfinder()">
				</td>
		</tr>
		<tr>
				<td>주소</td>
				<td><input type="text" name="addr" id="addr"  size="50"></td>
		</tr>
		<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
		</tr>
		<tr>
		<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
		</td>
		</tr>
</table>
</form>

</body>
</html>