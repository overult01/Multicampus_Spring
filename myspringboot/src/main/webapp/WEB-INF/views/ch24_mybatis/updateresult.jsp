<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${updateresult == 1}">
	<h3>${param.id} 회원님, 정상적으로 정보수정되었습니다.</h3>
</c:if>

<a href ="membermybatislist">회원리스트 보러가기</a>

</body>
</html>