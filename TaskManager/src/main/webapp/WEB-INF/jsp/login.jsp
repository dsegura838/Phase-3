<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="/login" method ="post">
		<label for="email">Email</label>
		<input type="text" id="email" name="email"><br>
		
		<label for="password">Password</label>
		<input type="text" id="password" name="password"><br>
		
		<br>
  		<input type="submit" value="Submit">
	
	</form>

</body>
</html>