<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit user</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Mono&display=swap" rel="stylesheet">
</head>
<body>
<section>
<h1>Edit user</h1>
	<form action="http://localhost:8080/book-store-application/UserEditServlet" method="POST">
	First Name: <input type="text" name="lastName"/> <br>
	Last Name: <input type="text" name="firstName"/> <br>
	Email: <input type="text" name="email"/> <br>
	Password: <input type="password" name="password"/> <br>
	
	<input type="submit" value="Confirm"/>
	
	
	
	</form>
</section>

</body>
</html>