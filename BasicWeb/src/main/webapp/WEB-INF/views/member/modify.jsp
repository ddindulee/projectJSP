<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<form action="/members/update" method="post">
		<input type="text" name="id" readonly="readonly" value="${param.id}"><br>
		<input type="email" name="email" placeholder="이메일을 입력해주세요."  value="${member.email }"><br>
		<input type="password" name="password" placeholder="비밀번호를 입력해주세요." value="${member.password }"><br>
		<input type="text" name="name" placeholder="이름을 입력해주세요." value="${member.name}"><br>
		<button type="submit">수정</button>
		<button type="reset">다시쓰기</button>
	</form>
</body>
</html>