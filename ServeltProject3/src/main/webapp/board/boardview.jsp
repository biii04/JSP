<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp"%>
    <div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Board Detail</h1>
	</div>
</div>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="mb-3">
		<a href="write"><button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button></a>
	</div>
	
	
<table class="table table-hover">
<form action = "board.update" method="post">
<tr>
	<th>userid</th>
	<td>${board.userid }</td>
</tr>
<tr>
	<th>subject</th>
	<td>${board.subject }</td>
</tr>
<tr>
	<th>email</th>
	<td>${board.email }</td>
</tr>
<tr>
	<th>content</th>
	<td>${board.content }</td>
</tr>

<tr>
	<th colspan="2">
	<input type = "submit" value = "수정" class="btn btn-outline-warning">
	<input type = "button" value = "삭제" onclick="loaction.href='board.delete'" class="btn btn-outline-danger">
	<input type = "reset" value = "취소" class="btn btn-outline-secondary">
	<input type = "button" value = "전체보기" onclick="location.href='board.list'" class="btn btn-outline-primary">
	</th>
</tr>
</form>
</table>
</div>

</body>
</html>


<%@ include file="../include/footer.jsp"%>