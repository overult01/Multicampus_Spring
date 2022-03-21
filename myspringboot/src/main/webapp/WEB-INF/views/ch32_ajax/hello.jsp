<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
//항상 데이터 요청은 반드시 클라이언트측(유저, 혹은 브라우저)이 먼저한다.
$(document).ready(function(){
	$("h1").css("color","blue");
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url:'/helloajax',
			type:'get',
			
			// 서버 응답 부분
			dataType:'json',
			success:function(result){ //MemberDTO -JSON변환
				$("#result").html(result.id +":" + result.password);
			}
		});
	});
});
</script>

<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<img src="images/drinks.jpg">
<h1>${model }</h1>
<input type=button value ="ajax요청" id ="ajaxbtn">
<div id="result"></div>

</body>
</html>