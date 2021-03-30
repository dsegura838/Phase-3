<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
</head>
<body>
	<h2>Tasks</h2>
	
	<table style="float:left">
	   <tr><th>ID</th><th>Name</th><th>Description</th><th>Start Date</th><th>End Date</th><th>Severity</th>
	   		<th>User ID</th></tr>
	   <c:forEach items="${tasks}" var="task" varStatus="count">
	    <tr id="${count.index}">
	    	<td>${task.id}</td>
	        <td>${task.name}</td>
	        <td>${task.description}</td>
	        <td>${task.startDate}</td>
	        <td>${task.endDate}</td>
	        <td>${task.severity}</td>
	        <!--<td>${task.user_id}</td> -->
	        <td>
	        	<a href = "/update/${task.id}">Edit Task</a>
	        	<a href ="/delete/${task.id}">Delete Task</a>
	        </td>
	    </tr>
	  </c:forEach>
	</table>
</body>
</html>