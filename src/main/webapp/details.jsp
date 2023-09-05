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
<title>Details</title>
</head>
<body>
<section>
<h1>Book Description</h1>
<a href="books.jsp">Go back to books</a>
 		
<table>
	<tr>
		<th>Book Title</th>
		<td><%= request.getParameter("bookName") %></td>
	</tr>
	<tr>
		<th>Book Author</th>
		<td><%= request.getParameter("bookAuthor") %></td>
	</tr>
	<tr>
		<th>Book Description</th>
		<td><%= request.getParameter("bookDescription") %></td>
	</tr>
	<tr>
		<th>Book Price</th>
		<td><%= request.getParameter("bookPrice") %></td>
	</tr>
		<tr>
		<td>
		<form method="POST" action="http://localhost:8080/book-store-application/AddToBasketServlet">
 		
 		<input type="hidden" name="isbn" value=<%=request.getParameter("bookISBN")%>>

 		<input type="submit" value="Add to basket"/>
 		</form>
		</td>
	</tr>
</table>

</section>

</body>
</html>