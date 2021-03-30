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
	
	<form action = "/update" method = "Post" >
		Enter Name: <input type = "text" name = "name" value ="${task.name}"><br>
		<input type="hidden" id="id" name="taskId" value="${task.id}">
		<input type="hidden" id="user" name="userID" value="${task.user.id}">
		Enter Start Date: <input type="date" id="sdate" name="sdate" value="${task.startDate}"><br>
		Enter End Date: <input type="date" id="edate" name="edate" value="${task.endDate}"><br>
		Enter Description: <textarea id="description" name="description" value = "${task.description}" rows=10 cols=30></textarea><br>
		Enter Severity: <select id="severity" name="severity" value ="${task.severity}">
		  	<option value="high">High</option>
		  	<option value="medium">Medium</option>
		  	<option value="low">Low</option>
		 </select>
		<input type = "submit">
	</form>
		
</body>
</html>