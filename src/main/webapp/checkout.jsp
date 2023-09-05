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
<title>Checkout</title>
</head>
<body>
<h1>Checkout</h1>
<section>
<a href=basket.jsp>Back to basket</a>


<ul>
<c:if test="${!basket.isEmpty() }">
	<c:forEach var="par" items="${basket}">
 		<li>${par}</li>
 	</c:forEach> 
 		 	
 </c:if>
</ul>
<c:out value="${total}"/>
 		<form method="POST" action="http://localhost:8080/book-store-application/PurchaseServlet">
 		
 		<input type="hidden" name="username" value="${username}">

 		<input type="submit" value="Purchase"/>
 		</form>



</section>

</body>
</html>