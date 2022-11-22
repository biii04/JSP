<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="board" class = "com.board.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="board"/>

<%
BoardDAO dao = BoardDAO.getInstance();
board.setIp(request.getRemoteAddr()); //IP부여
int flag = dao.boardUpdate(board);


if(flag ==1){
	response.sendRedirect("list.jsp");
} else{
%>

<script>
alert("비밀번호가 일치하지 않습니다");
history.back() //이전 페이지로 이동==history.go(-1) ->(-1)이 한 페이지 이전이라는 뜻
</script>

<%
}
%>