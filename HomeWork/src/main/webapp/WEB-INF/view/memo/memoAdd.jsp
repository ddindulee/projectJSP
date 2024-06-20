<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록화면</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/memos/add" method="post">
		<div>
			<label>제목: </label>
			 <input type="text" name="title">
		</div>
		
		<div>
			<label>내용: </label>
			<textarea name="content"></textarea>
		</div>
		
		<label>작성자: </label>
		<div>
			<input type="text" name="writer">
		</div>
		
		<button type="submit">저장</button>
	</form>
</body>
</html>