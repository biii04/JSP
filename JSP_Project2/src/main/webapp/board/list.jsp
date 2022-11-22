<%@page import="com.board.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Board List</title>
<%
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum");
	if(pageNum ==null ){
		pageNum="1";
	}
	String field = "";
	String word = "";
	if(request.getParameter("word")!=null){
		field = request.getParameter("field");
		word = request.getParameter("word");
	}
	int currentPage = Integer.parseInt(pageNum); //현재페이지
	int pageSize=5;  //한 화면에 보여지는 게시물 수
	
	int startRow = (currentPage -1) * pageSize +1 ;  //1 6 11
	int endRow = currentPage * pageSize;  //5 10 15
	
    BoardDAO dao = BoardDAO.getInstance();
    ArrayList<BoardDTO> arr =dao.boardList(field, word, startRow, endRow);
    int count = dao.getCount(field, word);
%>
</head>
<body>
<div class="container mt-3">
<div align = "right">
<a href="writeForm.jsp">글쓰기</a>

</div>

<h2>게시글 목록(<%=count %>)</h2>
<table class="table table-striped">
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
 <%
 	for(BoardDTO board:  arr){
 %>		
 		<tr>
	 		<td><%=board.getNum() %></td>
	 		<td><a href="boardView.jsp?num=<%=board.getNum() %>"><%=board.getSubject() %></a></td>
	 		<td><%=board.getWriter() %></td>
	 		<td><%=board.getReg_date() %></td>
	 		<td><%=board.getReadcount()%></td>
  		</tr>
<% 		
 	}
  %>
 
 
 </tbody>

</table>

<!-- 검색버튼 -->
<br/><br/>
<form action="list.jsp" name = "search" method="get">
	<select name = "field">
		<option value = "subject">제목
		<option value = "writer"> 작성자
	</select>
	
	<input type = "text" size = 16, name = "word">
	<input type = "submit" value = "찾기"> 

</form>

<div align = "center">

<%
if(count>0){  //게시글 38개, 한 화면 5개 ==> 38/5 =7개 + 1개 =8개 나머지 있으면 1을 더하기

	int pageCount = count/pageSize +(count%pageSize ==0?0:1);
	int pageBlock = 3;
	int startPage = (int)((currentPage-1)/pageBlock)*pageBlock+1; //(7-1)/3=2*3+1=7
	int endPage = startPage + pageBlock -1;  //4+3-1=6
	if(endPage > pageCount){  //현재 9라고 가정했을 때 9(계산상) > 8(실제)
		endPage = pageCount;  //endPage = 8
	}
	//이전
	if(startPage > pageBlock){
	%>	
		<a href = "list.jsp?pageNum=<%=startPage-pageBlock %>&field=<%=field%>&word=<%=word%>">[이전]</a>
	<%
	}
	
	//페이지 번호
	for(int i =startPage; i<=endPage;i++){
		if(i==currentPage){  //링크없음
	%>	
		[<%=i%>]
	<%	
		}else{  //링크	
%>
		[<a href="list.jsp?pageNum=<%=i %>&field=<%=field%>&word=<%=word%>"><%=i%>]	</a>
<%
		}
	}		
	//다음
	if(endPage < pageCount){
	%>
		<a href="list.jsp?pageNum=<%=startPage+pageBlock %>&field=<%=field%>&word=<%=word%>">[다음]</a>
	<%
	}
}
%>

</div>
</div>
</body>
</html>