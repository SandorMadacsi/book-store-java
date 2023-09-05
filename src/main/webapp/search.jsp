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
<title>Search</title>
</head>
<body>
<section>
	<form action="http://localhost:8080/book-store-application/SearchBookServlet" method="POST">
	
	Book author: <input type="text" name="search"/> <br>

	<p>Please select what to search by: </p>
	<input type="radio" id="author" name="option" value="AUTHOR" checked="checked"/>
	<label for="author">Author</label> <br>
	<input type="radio" id="isbn" name="option" value="ISBN"/>
	<label for="isbn">ISBN</label> <br>
	<input type="submit" value="Search"/>
	</form>
	

</section>

</body>
</html>