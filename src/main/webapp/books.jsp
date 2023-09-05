<%@page import="com.bs.models.Book"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono&display=swap" rel="stylesheet">
<title>Book shop Application | Books</title>
</head>
<body>
<section>
<
<%-- <% Book b  = (Book) request.getAttribute("book"); %>
<%= b %> --%>
<a href="home.jsp">Back to home page</a>
<ul>
	<c:forEach var="par" items="${booklist}">
 		<li class="item">${par.getBookName()}
 		<c:url value="details.jsp" var="details">
 		<c:param name="bookName" value="${par.getBookName()}"></c:param>
 		<c:param name="bookAuthor" value="${par.getBookAuthor()}"></c:param>
 		<c:param name="bookDescription" value="${par.getBookDescription()}"></c:param>
 		<c:param name="bookISBN" value="${par.getBookISBN()}"></c:param>
 		<c:param name="bookPrice" value="${par.getBookPrice()}"></c:param>
		</c:url>
		
<%-- 		<c:url value="http://localhost:8080/book-store-application/AddToBasketServlet" var="basketItem">
 		<c:param name="isbn" value="${par.getBookISBN()}"></c:param>
		</c:url> --%>
		<a href="${details}">Details</a>
	<%-- 	<a href="${basketItem}">Add to basket</a> --%>
		<form method="POST" action="http://localhost:8080/book-store-application/AddToBasketServlet">
 		
 		<input type="hidden" name="isbn" value="${par.getBookISBN()}">

 		<input type="submit" value="Add to basket"/>
 		</form>
 	
 		</li>
 	</c:forEach> 
</ul>




</section>

</body>
</html>