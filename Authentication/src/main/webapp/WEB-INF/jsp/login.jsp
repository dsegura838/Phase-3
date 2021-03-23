<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<h1><b>Enter Credentials<b></h1>
	<form action="/login" method = "post">
		<label for = "name" >Name:</label><br>
		<input type = "text" id = "name" name = "name"><br>
		<label for = "password">Password:</label><br>
		<input type = "text" id="password" name="password"><br>
		<input type = "submit" value = "submit">
	</form>
	<a href="/">Return to Main</a><br>
</body>
</html>