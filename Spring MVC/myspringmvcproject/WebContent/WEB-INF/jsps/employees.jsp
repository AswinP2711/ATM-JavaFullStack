<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
        background-color: #efefef;
        line-height: 1.3;
    }
    
    .employee-item{
        display: block;
        float: left;
        border: 1px solid #dfdfdf;  
        background-color: #fff;
        width: 21%; 
        padding: 15px;
        margin: 10px;
        border-radius: 10px;
    }
    .employee-item a{
        text-decoration: none;
    }
    .title-content {
        margin-left: 10px;
        margin-top: 15px;
    }
    .page-header{
        font-family: sans-serif;
        font-size: 2em;
        padding: 15px;
    }
    .add-link a{
    text-decoration: none;
    }
    .add-link  a:hover{
     color: black;
    }
</style>
</head>
<body>
	<c:import url="navbar.jsp" />
	<section>
	<div class="title-content">
	<span class="page-header">All Employees</span>
	<span class="add-link">
	<a href="${pageContext.request.contextPath}/show-add-employee">+Add Employee</a>
	</span>
	</div>
		<c:set var="sr" value="1" />
		<c:forEach items="${employeeList}" var="e">
			<div class="employee-item">
				<span>Employee No. : <c:out value="${sr}" /></span> <br> 
				<span>Name : <c:out value="${e.name}" /></span> <br> 
				<span>Salary : <c:out value="${e.salary}" /></span> <br>
				<span>Branch : <c:out value="${e.branch}" /></span> <br>
				<a href="#">Edit</a> | <a href="#">Delete</a>
			</div>
			<c:set var="sr" value="${sr=sr+1}" />
		</c:forEach>
	</section>
</body>
</html>