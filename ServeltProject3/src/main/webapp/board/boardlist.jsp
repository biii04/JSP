<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Board List(${count })</h1>
	</div>
</div>

<div class="container">
	<div class="mb-3">
		<a href="write"><button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button></a>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board" varStatus="st">
				<tr>
					<td>${board.num}</td>
					<td><a href="board.view?num=${board.num }">${board.subject }</a></td>
					<td>${board.userid }</td>
					<td>${board.regdate }</td>
					<td>${board.readcount }</td>
				</tr>


			</c:forEach>

		</tbody>
	</table>
	</div>

<%@ include file="../include/footer.jsp"%>