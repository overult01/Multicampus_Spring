<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC로 로그인 구현</title>
</head>
<body>

<p>둘 모두 같은 결과</p>
<h1>el: ${loginresult}</h1>
<h1>내장객체: <%= request.getAttribute("loginresult") %></h1>

<h1>el(dto 내용 출력): ${dto.id}회원님 암호는 ${dto.password} 입니다.</h1>

</body>
</html>