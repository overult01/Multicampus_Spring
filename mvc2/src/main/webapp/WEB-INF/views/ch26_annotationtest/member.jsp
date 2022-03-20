<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링MVC annotation 실습 - 회원가입 입력값 출력(el은 getter용도이기 때문에 get빼고 변수처럼 호출)</title>
</head>
<body>

<h3>
아이디: ${dto.id}
암호: ${dto.password}
이름: ${dto.name}
전화번호: ${dto.phone}
이메일: ${dto.email}
주소: ${dto.address}
</h3>


</body>
</html>