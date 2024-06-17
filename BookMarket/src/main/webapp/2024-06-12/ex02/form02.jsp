<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="form02_process.jsp" method="post">
		<p>
			이름: <input type="text" name="userName">
		</p>

		<p>
			주소: <input type="text" name="userAdress">
		</p>
		
		<p>
			이메일: <input type="email" name="userEmail">
		</p>
		
		<button>전송</button>

	</form>
</body>
</html>