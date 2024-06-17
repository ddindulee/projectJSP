<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	c:if는 1개의 조건만 처리 가능
	자바의 if else 는 c:choose c:when c:otherwise를 사용해야함
 -->
 <c:choose>
 	<c:when test="${member != null}">
 		<div>${member.id }</div>
 		<div>${member.email}</div>
 		<div>${member.name }</div>
 		<div>${member.registerDate}</div>
 		<div>
 			<a href="/members/update?id=${member.id }">수정</a>
 			<form action="/members/delete" method="post">
 				<input type="hidden" name="id" value="${member.id }">
 				<button>삭제</button>
 			</form>
 		</div>
 	</c:when>
 	<c:otherwise>회원이 존재하지 않습니다.</c:otherwise>
 </c:choose>

</body>
</html>