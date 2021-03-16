<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<h1>Enter updated details</h1>
	
	<form action = update method = "Post" >
		Enter Name: <input type = "text" name = "name" value ="${user.name }"><br>
		Enter email: <input type = "text" name = "email" value = "${user.email }"><br>
		Enter Password: <input type = "text" name = "password" value = "${user.password}"><br>
		<input type = "submit">
	</form>
		
</body>
</html>