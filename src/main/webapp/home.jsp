<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono&display=swap" rel="stylesheet">
<title>Book Shop Application | Home page</title>
</head>
<body>


<section>

	<h1>Book Shop Web Application</h1>
	<h2>Welcome on the home page</h2>
	<c:if test="${loggedInUser != null}">
      <p><c:out value="${loggedInUser.getFirstName()}"/></p>
 		 	
 </c:if>
	<ul class="main-menu">
		<li><a href="http://localhost:8080/book-store-application/ListBookServlet">Books</a></li>
		<li><a href="search.jsp">Search</a></li>
		<c:if test="${loggedInUser == null}">
		<li><a href="login.jsp">Login</a></li> 	
 		</c:if>

		<li><a href="register.jsp">Register</a></li>

<c:if test="${loggedInUser != null}">
      <li><a href="user.jsp">User</a></li>
 		 	
 </c:if>
		
	</ul>
</section>
<!-- <h1>Aren't any  books</h1> -->
</body>
</html>