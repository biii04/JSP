<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "person" method="get">
	
	이름 : <input type = "text" name = "name" id = "name"><br/><br/>
	나이 : <input type = "text" name = "age" id = "age"><br/>	
	<hr/>
	
	성별 : <br/><label for="m">남자</label>
	<input type = "radio" name = "gender" value = "남자" id=m checked>
	<label for="f">여자</label>
	<input type = "radio" name = "gender" value = "여자" id=f> <br/>
	<hr/>
	
	관심분야 : <br/>
	<label for = "h1">운동</label>
	<input type = "checkbox" name = "hobby" value = "운동" id = h1> <br/>
	<label for = "h2">게임</label>
	<input type = "checkbox" name = "hobby" value = "게임" id = h2> <br/>
	<label for = "h3">등산</label>
	<input type = "checkbox" name = "hobby" value = "등산" id = h3> <br/>
	<label for = "h4">독서</label>
	<input type = "checkbox" name = "hobby" value = "독서" id = h4> <br/>
	<label for = "h5">영화</label>
	<input type = "checkbox" name = "hobby" value = "영화" id = h5> <br/>
	<hr/>
	
	직업 : <br/><select name = "job">
	<option value = "학생">학생</option>
	<option value = "공무원">공무원</option>
	<option value = "회사원">회사원</option>
	<option value = "취준생">취준생</option>
	<option value = "기타">기타</option>
	</select>
	<br/><br/>
	<input type = "submit" value = "전송">
	<hr/>
	</form>
</body>
</html>