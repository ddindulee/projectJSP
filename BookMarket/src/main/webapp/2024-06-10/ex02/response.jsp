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
	<%
		response.setHeader("Refresh", "5"); 
		Calendar cal = Calendar.getInstance();
		
		%>
	<p>
		현재시간:
		<%= cal.getTime() %></p>
	<a href="response_data.jsp">Google 홈페이지로 이동하기</a>




</body>
</html>