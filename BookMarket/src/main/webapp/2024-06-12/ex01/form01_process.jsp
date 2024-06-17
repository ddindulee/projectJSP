<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String queryString = request.getQueryString();
	%>
	이름: <%=request.getParameter("userName")%><br>
	주소: <%=request.getParameter("userAdress")%><br>
	이메일: <%=request.getParameter("userEmail")%>
</body>
</html>