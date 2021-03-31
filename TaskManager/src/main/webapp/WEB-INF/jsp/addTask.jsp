<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
</head>
<body>

<form action="/add" method="post">
 <label for="name">Task name:</label><br>
  <input type="text" id="name" name="name"><br>
  
  <label for="userID">UserID:</label><br>
  <input type="number" id="userID" name="userID" value = "${userID}"><br>
  
  <label for="sdate">Start Date:</label><br>
  <input type="date" id="sdate" name="sdate"><br>
  
  <label for="edate">End Date:</label><br>
  <input type="date" id="edate" name="edate"><br>
  
  <label for="description">Description:</label><br>
  <textarea id="description" name="description" rows=10 cols=30></textarea><br>
  
  <label for="severity">Severity</label><br>
  <select id="severity" name="severity">
  	<option value="high">High</option>
  	<option value="medium">Medium</option>
  	<option value="low">Low</option>
  </select>
  
   
  <br>
  <input type="submit" value="Submit">

</form>
</body>
</html>