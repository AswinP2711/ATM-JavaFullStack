<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="navbar.jsp" />
	<div>
		<span>Date : <c:out value="${dateVal}" /></span>
		<c:set var="x" value="7" />
		<c:set var="y" value="9" />
		<br /> <strong>x+y = <c:out value="${x+y }"></c:out></strong>
	</div>
</body>
</html>