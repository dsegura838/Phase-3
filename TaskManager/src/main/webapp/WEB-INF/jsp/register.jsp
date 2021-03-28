<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>

	<style>
		h1{text-align:center;}
	</style>
</head>
<body>
	<form name="registrationForm" method="post" action="register">
  		<div class="container">
			<h1>Welcome new user</h1>
			<p>Register here</p>
			<hr>
			
			<label for="name"><b>Name</b></label>
		    <input type="text" placeholder="Enter Name" name="name" id="name" required>
			
		    <label for="email"><b>Email</b></label>
		    <input type="text" placeholder="Enter Email" name="email" id="email" required>
		    
		    <label for="password"><b>Password</b></label>
		    <input type="password" placeholder="Enter Password" name="password" id="password" required>
		    
		    <button type="submit" class="registerbtn">Register</button>
		    
		</div>
		
		<div class="container signin">
		    <p>Already have an account? <a href="login">Sign in</a>.</p>
		</div>
	</form>
	
	
	
	
</body>
</html>