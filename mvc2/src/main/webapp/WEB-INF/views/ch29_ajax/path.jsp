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

<h1>현재 회원 아이디는 ${id}</h1> <!-- id는 서버에서 전달받은 모델 이름(파라미터가 아니라서 param.id가 x) --> 

</body>
</html>