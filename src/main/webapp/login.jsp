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
<title>Login</title>
</head>
<body>
<section>
	<form action="http://localhost:8080/book-store-application/UserLoginServlet" method="POST">
	
	Email: <input type="text" name="email"/> <br>
	Password: <input type="text" name="password"/> <br>
	
	<input type="submit" value="Login"/>
	</form>
	
	Unregistered? <a href="register.jsp">Click here to register</a>
</section>

</body>
</html>