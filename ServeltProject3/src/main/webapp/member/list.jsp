<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Member List</h1>
	</div>
</div>
<div class="container">
	<div class="mb-3">
		<a href="write"><button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button></a>
	</div>
	<table class="table table-hover">
<thead>
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>구분</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="board" varStatus="st">
				<tr>
					<td>${board.name }</td>
					<td>${board.userid }</td>
					<td>${board.phone }</td>
					<td>${board.email }</td>
					<td>${board.admin }</td>
				</tr>
				
				</c:forEach>
			</tbody>
</table>
</div>
<%@ include file="../include/footer.jsp"%>