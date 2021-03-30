<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>


<h2>Users</h2>

<table style="float:left">
   <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>List Tasks</th><th>Add Tasks</th></tr>
   <c:forEach items="${users}" var="user" varStatus="count">
    <tr id="${count.index}">
    	<td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>
        <td>
        	<a href = "/display/${user.id}/">List Tasks</a>
        </td>
        <td>
        	<a href = "/add/${user.id}/">Add Tasks</a>
        </td>
        
    </tr>
  </c:forEach>
</table>

<a href = "/">Back to Main</a><br>
</body>
</html>

