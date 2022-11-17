<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="upload.do" method="post" enctype="multipart/form-data"> 
<!-- 파일 업로드는 method가 반드시 post여야하고, enctype은 기본적으로 정해주는거 말고 multipart/form-data를 사용해야함 -->
	글쓴이 : <input type="text" name = "name"/><br/>
	제목 : <input type="text" name = "title"/><br/>
	파일 : <input type="file" name = "uploadFile"/><br/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>