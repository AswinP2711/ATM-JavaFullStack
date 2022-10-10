<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #efefef;
	line-height: 1.3;
}

.product-item {
	display: block;
	float: left;
	border: 1px solid #dfdfdf;
	background-color: #fff;
	width: 20%;
	padding: 15px;
	margin: 10px;
	border-radius: 10px;
}

h1 {
	margin-left: 10px;
}
</style>
</head>
<body>
	<c:import url="navbar.jsp" />
	<section>
		<h1>All Products</h1>
		<c:set var="sr" value="1" />
		<c:forEach items="${productList}" var="p">
			<div class="product-item">
				<span>Product No. : <c:out value="${sr}" /></span> <br> <span>Title
					: <c:out value="${p.title}" />
				</span> <br> <span>Price : <c:out value="${p.price}" /></span> <br>
				<span>Vendor : <c:out value="${p.vendor}" /></span> <br>
			</div>
			<c:set var="sr" value="${sr=sr+1}" />
		</c:forEach>
	</section>
</body>
</html>