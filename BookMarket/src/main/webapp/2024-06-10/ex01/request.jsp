<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="request_process.jsp" method="get">
		<p>
			아이디: <input type="text" name="userId">
		</p>

		<p>
			비밀번호: <input type="password" name="userPassword">
		</p>
		
		<button>전송</button>

	</form>
</body>
</html>