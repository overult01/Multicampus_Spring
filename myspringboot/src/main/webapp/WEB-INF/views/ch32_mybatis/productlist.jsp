<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	$(document).ready( function(){ 
		// jquery code
	});
</script>

<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>


<c:forEach items="${productlist }" var="dto">
	${dto.productcode} 
	<a href = "/product?code=${dto.productcode}">${dto.productname }</a> 
	${dto.price }<br>
</c:forEach>

</body>
</html>