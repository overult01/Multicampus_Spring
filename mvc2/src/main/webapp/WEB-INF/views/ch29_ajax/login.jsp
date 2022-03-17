<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	$(document).ready( function(){ 
		// /ajax/login 매핑 메서드 호출(id, password)
		// html태그의 name 속성은 서버에서 가져오려는 것. id속성은 제이쿼리, 자바스크립트에서 가져오려는 것 
		
		// 로그인
		$("#ajaxbtn").on('click', function(){
			$.ajax({
				// 서버에 요청 부분 
<%-- 				 <%=request.getContextPath()%> 는 /mvc2다  --%>
				url: "<%=request.getContextPath()%>/ajax/login",
				data: {'id':$("#id").val(), // id가 id인 태그의 value속성 제이쿼리로 읽어오기 
					'password':$("#password").val() 
					},
				type: 'post',
				
				// 서버 응답 부분
				dataType: 'json', // json형식으로 받는다 
				
				// {"bb" : "xxx", "cc" : "xxx"} 형태로 서버 리턴결과를 받는다. 
				success: function(a) { // 매개변수 a는 서버에서 전달해준 값을 의미. 서버에서 String 타입으로 받음/
					alert(JSON.stringify(a)); // stringify(a): a객체를 String으로 변환. 그냥 a출력하면 [Object]로 나온다.
					// 서버 리턴값 사용
					$("#loginresult").html("<h3>" + a.role + "로 로그인</h3>"); // html메서드: 덮어쓰기
					$("#loginresult").append("<h3> 관리자 역할로" + a.process + "</h3>"); // append메서드: 기존내용에 추가 
					
				}// success send
			}); // ajax end
		}); // on end
		
		
		// 내 정보 조회 
		$("#ajaxbtn2").on('click', function(){
			$.ajax({
				// 서버에 요청 부분 
				url: "<%=request.getContextPath()%>/ajax/myinform",
				data: {'id':$("#id").val(), // id가 id인 태그의 value속성 제이쿼리로 읽어오기 
					'password':$("#password").val() 
					},
 				type: 'get',
				
				// 서버 응답 부분
				dataType: 'json', // json형식으로 받는다 
				
				// {"bb" : "xxx", "cc" : "xxx"} 형태로 서버 리턴결과를 받는다. 
				success: function(dto) { // MemberDTO 객체(자바 객체)를 json 변환 객체로 
					if(dto.id == "new") {
						$("#informresult").html("<h3>회원정보를 못찾았습니다.");
					}
					else if(dto.password == 'new') {
						$("#informresult").html("<h3>암호가 다릅니다.</h3>");						
					}
					// 서버 리턴값 사용
					else {
						$("#informresult").html("<h3> 회원아이디 = " + dto.id + "</h3>");
						$("#informresult").append("<h3> 회원이름 = " + dto.name + "</h3>");
						$("#informresult").append("<h3> 회원폰 = " + dto.phone + "</h3>");
						$("#informresult").append("<h3> 회원이메일 = " + dto.email + "</h3>");	
						$("#informresult").append("<h3> 회원주소 = " + dto.address + "</h3>");
					}
				}// success send
			}); // ajax end
		}); // on end

		
		// 회원리스트 조회 
		$("#ajaxbtn3").on('click', function(){
			$.ajax({
				// 서버에 요청 부분 
				url: "<%=request.getContextPath()%>/ajax/memberlist",
/* 				data: {'id':$("#id").val(), // id가 id인 태그의 value속성 제이쿼리로 읽어오기 
					'password':$("#password").val() 
					},
 */				type: 'get',
				
				// 서버 응답 부분
				dataType: 'json', // json형식으로 받는다 
				
				// {"bb" : "xxx", "cc" : "xxx"} 형태로 서버 리턴결과를 받는다. 
				success: function(list) { // ArrayList<MemberDTO> 객체를 json 변환 객체로 
					
					// 서버 리턴값 사용
					var table = "<table border = 3>";
					for (var i = 0; i < list.length; i++) {
						table += "<tr><td>" + list[i].id + "</td><td>" + list[i].name + "</td><td>" + list[i].address +"</td></tr>";
					}
					table += "</table>";
					$("#listresult").html(table);					
				}// success send
			}); // ajax end
		}); // on end

		
	});// ready end
</script>

<title>ajax: 일부분만 갱신</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

아이디 <input type = text name = "id" id="id"><br>
암호 <input type = password name ="password" id ="password"><br>
<input type = button value ="ajax로그인" id ="ajaxbtn">
<input type = button value ="내정보조회" id ="ajaxbtn2">
<input type = button value ="전체회원" id ="ajaxbtn3">

<div id = "loginresult" style ="background-color:silver">로그인 결과는 여기에 표시됩니다.</div><br>
<div id = "informresult" style ="background-color:pink">내 정보 조회는 여기에 표시됩니다.</div><br>
<div id = "listresult" style ="background-color:lime">모든회원 조회는 여기에 표시됩니다.</div>

</body>
</html>