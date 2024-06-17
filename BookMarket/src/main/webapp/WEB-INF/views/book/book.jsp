<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="book.BookRepository"%>
<%@page import="book.BookVO"%>
<jsp:useBean id="repository" class="book.BookRepository" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=pageContext.getServletContext().getContextPath()%>/css/bootstrap.min.css">
<title>도서 정보</title>
</head>
<body>
<body>
	<div class="container py-4">
		<%@include file="/WEB-INF/views/fragments/header.jsp"%>

		<main>
			<div class="p-5 mb-4 bg-body-tertiary rounded-3">
				<div class="container-fluid py-5">
					<h1 class="display-5 fw-bold">도서 정보</h1>
					<p class="col-md-8 fs-4">BookInfo</p>
				</div>
			</div>
			<!-- 		자바의 BookRepositoy클래스에서 getBooks()호출 -->
			<div class="row align-items-md-stretch text-center">
				<%
				String id = request.getParameter("id");
				BookVO book = repository.getBook(id);
				%>
				<div class="col-md-12">
					<h3 class="fw-bold"><%=book.getTitle()%></h3>
					<p><%=book.getDescription()%></p>
					<p><%=book.getId()%></p>
					<p><%=book.getAuthor()%></p>
					<p><%=book.getPublisher()%></p>
					<p><%=book.getReleaseDate()%></p>
					<p><%=book.getCategory()%></p>
					<p><%=book.getQuantity()%></p>
					<p><%=book.getPrice() + "원"%></p>
					<p>
						<a href="#" class="btn btn-info">도서주문</a> <a href="/books.jsp"
							class="btn btn-secondary">도서목록</a>
					</p>
				</div>
			</div>
		</main>
		<%@include file="/WEB-INF/views/fragments/footer.jsp"%>

	</div>

	<script
		src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>

</body>
</html>