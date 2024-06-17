<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<form action="/members/new" method="post">
		<input type="email" name="email" placeholder="이메일을 입력해주세요."><br>
		<input type="password" name="password" placeholder="비밀번호를 입력해주세요."><br>
		<input type="text" name="name" placeholder="이름을 입력해주세요."><br>
		<button type="submit">회원가입</button>
		<button type="reset">다시쓰기</button>
	</form>
</body>
</html>