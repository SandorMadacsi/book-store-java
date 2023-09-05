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
<title>User Dashboard</title>
<section>
<a href="home.jsp">Go back to home</a>
<table>
	<tr>
		<th>First Name</th>
		<td><c:out value="${loggedInUser.getFirstName()}"/></td>
	</tr>
	<tr>
		<th>Last Name</th>
		<td><c:out value="${loggedInUser.getLastName()}"/></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><c:out value="${loggedInUser.getEmail()}"/></td>
	</tr>
	<tr>
		<th>Password</th>
		<td><c:out value="${loggedInUser.getPassword()}"/></td>
		
	</tr>
	<tr>
	<td><a href="edit.jsp">Edit details</a> </td>
	</tr>
</table>
</section>

</head>
<body>

</body>
</html>