<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!--/04/formProcess.jsp -->
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
// 	post 방식일 때 파라미터 값을 가져오기 전에 한번만 써준다.
	request.setCharacterEncoding("utf-8");
/* 
	String userId =	request.getParameter("userId");
	String userPassword = request.getParameter("userPassword");
	String userName = request.getParameter("userName");
	String userphoneNumber1= request.getParameter("phone1");
	String userphoneNumber2= request.getParameter("phone2");
	String userphoneNumber3= request.getParameter("phone3");
	String gender= request.getParameter("gender");
	String[] hobbies= request.getParameterValues("hobby");
	
	out.println("ID: "+userId);out.println("<br>");
	out.println(userPassword);out.println("<br>");
	out.println(userName);out.println("<br>");
	out.println(userphoneNumber1);out.println("<br>");
	out.println(userphoneNumber2);out.println("<br>");
	out.println(userphoneNumber3);out.println("<br>");
	out.println(gender);out.println("<br>");
	for(String str : hobbies){
		out.println(str);
	} */
	
//폼 데이터를 한번에 받기
	Enumeration<String> parameterNames = request.getParameterNames();
	while(parameterNames.hasMoreElements()){
		String param =  parameterNames.nextElement();
		String paramValue = request.getParameter(param);
		out.println(paramValue); out.println("<br>");
	}
%>
</body>
</html>