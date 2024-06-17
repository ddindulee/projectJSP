<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- request 객체를 사용하여 요청 파라미터와 값을 출력 --%>
    <%
        // request 객체 가져오기
        String queryString = request.getQueryString();
    	out.print("<br/>");
    %>
    <p>전송된 요청 파라미터와 값: <%= queryString %></p>
</body>
</html>