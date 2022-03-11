<%@page import="nonspsringmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>컨트롤러로부터 전달받은 모델 데이터</h1>
<% HelloDTO dto = (HelloDTO)request.getAttribute("model"); %>
<h3> <%= dto.getMessage() %></h3>

</body>
</html>