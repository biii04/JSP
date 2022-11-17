<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>Board Write</h1>      
  </div>
</div>

<div class="container">
<form action="write" method="post">
<div class="form-group">
	<label for="name">Userid</label> 
	<input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid">
</div>

<div class="form-group">
	<label for="name">Subject</label> 
	<input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
</div>

<div class="form-group">
	<label for="name">Email</label> 
	<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
</div>

<div class="form-group">
	<label for="name">content:</label> 
	<input type="text" class="form-control" rows="5" id="content" placeholder = "insert your idea" name="content">
</div>
<button type="submit" class="btn btn-primary">글쓰기</button>
</form>
</div>


<%@ include file="../include/footer.jsp"%>