<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="membermybatisupdate" method = "post"> <!-- action에 매핑된 컨트롤러를 찾아서 거기로 보내준다. -->
	아이디<input type=text name="id" value="${param.id}" readonly = "readonly"><br> <!-- 받아온 id 수정불가  -->
	이름<input type="text" name="name"><br>
	주소<input type="text" name="address"><br>
	<input type = submit value="정보수정하기">
</form>

</body>
</html>