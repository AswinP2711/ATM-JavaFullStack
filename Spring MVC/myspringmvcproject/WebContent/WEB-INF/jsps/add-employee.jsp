<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<c:import url="navbar.jsp" />
	<h1>Add Employee</h1>
	<form action="${pageContext.request.contextPath }/add-employee"
		method="get">
		<label>Employee Name: </label> 
		<input type="text" name="name" /> <br /><br /> 
		<label>Employee Salary: </label> 
		<input type="number" name="salary" /> <br /> <br /> 
		<label>Employee Branch: </label> 
		<input type="text" name="branch" /> <br /> <br />
		<input type="submit" value="Add Employee">
	</form>
</body>
</html>