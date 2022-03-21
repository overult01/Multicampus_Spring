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
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

코드: ${productdto.productcode }<br>
제품이름: ${productdto.productname }<br>
가격: ${productdto.price }<br>
회사명: ${productdto.company }<br>
수량: ${productdto.balance }<br>
입고일: ${productdto.regdate }<br>

</body>
</html>