<%@page import="com.board.dto.BoardDTO"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>

<script   src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>


</script>

<%
request.setCharacterEncoding("utf-8");
BoardDAO dao = BoardDAO.getInstance();
int num =Integer.parseInt(request.getParameter("num"));
BoardDTO board = dao.findByNum(num); //num뿐만 아니라 ref, re_step, re_level까지 모두 받아오고 싶기 때문에 더 적어주는거(지금 댓글 작업중)
int ref=board.getRef();
int re_step=board.getRe_step();
int re_level=board.getRe_level();
%>
</head>
<script>
function del(){
	if(confirm("삭제하시겠습니까?")){
		location.href="deletePro.jsp?num=<%=num%>";
	}
}
</script>
<body>
<div class="container" align = "center">
<h2>글 내용 보기</h2>
<input type ="hidden" id="num" value = "<%=num %>"/>
<table class="table table-striped">
	<tr>
		<td>글번호</td>
		<td><%=board.getNum() %></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><%=board.getReadcount() %></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><%=board.getWriter() %></td>
	</tr>
	<tr>
		<td>작성일</td>
		<td><%=board.getReg_date() %></td>
	</tr>
	<tr>
		<td>글제목</td>
		<td colspan="3"><%=board.getSubject() %></td>
	</tr>
	<tr>
		<td>글내용</td>
		<td colspan="3"><%=board.getContent() %></td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="button" value="글수정폼" 
			onclick = "location.href ='updateForm.jsp?num=<%=num%>'"/>
			<input type="button" value="삭제" onclick="del()" />
			<input type = "button" value = "답글쓰기" onclick = "location.href='writeForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'"/>
			<input type = "button" value = "글목록" onclick = "location.href='list.jsp'"/>
		</td>
	</tr>

</table>

<br/><br/>
<div align = "left">
	<textarea class="table-warning" rows="5" cols = "50" id="msg"></textarea>
	<input type="button" class="btn btn-outline-warning" value = "comment Insert" id = "commentBtn"/>

</div>
Comment(<span id="cntSpan"></span>)<br/>
<div id="result"></div>
<script>
var init=function(){
	$.getJSON("commentList.jsp",
			{"bnum":$("#num").val()},
			function(resp){
				var str="<table>"
				$.each(resp.dataObj, function(key,val){
					str+="<tr>"
					str+="<td>"+val.msg+"</td>"
					str+="<td>"+val.userid+"</td>"
					str+="<td>"+val.regdate+"</td>"
					str+="</tr>"
				})
				str +="</table>"
				$("#result").html(str)
				$("#cntSpan").text(resp.countObj.count)
			})
}


$("#commentBtn").click(function(){
	if($("#msg").val()==""){
		alert("메세지를 입력하세요")
		return;
	}
	$.ajax({
		type:"get",
		url:"commentInsert.jsp",
		data:{"msg":$("#msg").val(), "bnum":$("#num").val()},
		success:function(resp){
			if(resp.trim()==1){  //로그인 x
				alert("로그인하세요");
				location.href="../member/loginForm.jsp"; //상대경로
			}else{  //로그인 o
				init();
				$("#msp").val("")
			}

		},
		error:function(e){
			alert("error:"+e);
		}
	})//ajax
})//commentBtn
</script>
</div>
</body>
</html>