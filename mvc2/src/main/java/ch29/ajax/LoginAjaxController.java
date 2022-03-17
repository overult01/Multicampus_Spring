package ch29.ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch24.spring.mybatis.MemberDTO;
import ch24.spring.mybatis.MemberService;


@Controller
public class LoginAjaxController {

	@Autowired
	@Qualifier("mybatisservice")
	MemberService service;
	
	// 로그인폼을 뷰로 보여주는 메서드
	@RequestMapping(value = "/ajax/login", method = RequestMethod.GET)
	public String loginform() {
		return "ch29_ajax/login"; // @RequestMapping이 붙어있고, @ResponseBody가 안붙어있고, 리턴타입이 void면 value속성의 url로 뷰를 자동 지정하는 것.
	}
	
	// 로그인을 ajax로 처리하는 메서드 
	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"}) // produces 속성내용: 전달하는 형식은 json, 인코딩은 utf-8
	@ResponseBody // 리턴값이 반드시 json 형식 (뷰가 아님에 유의)
	public String loginresult(String id, String password) {
		
		if(id.equals("ajax") && password.equals("1234")) {
			// admin 역할로 정상 로그인 
			return "{\"process\" : \"정상로그인\", \"role\":\"admin\"}";
		}
		else {
			return "{\"process\" : \"비정상로그인\", \"role\":\"user\"}";
		}
	}
	
	@RequestMapping(value = "/ajax/myinform" , produces = {"application/json;charset=utf-8"})
	@ResponseBody  // ajax요청을 받는 컨트롤러라는 뜻. 리턴값은 String 형태로 반드시 Json
	public MemberDTO myinform(String id, String password) {
		// db 조회 생략(가짜)
/*		
		MemberDTO dto = new MemberDTO(id, password);
		dto.setName("홍길동");
		dto.setPhone("0101112222");
		dto.setEmail("hong@naver.com");
		dto.setAddress("서울");
*/		
		
		// 마이바티스 연동.(실제 DB연결) service, dao, dto, sql-mapping.xml
		MemberDTO dto = service.selectmember(id);
		System.out.println("ajax/myinform 호출: " + dto);
		// id있는지 확인
		if(dto == null) {
			dto = new MemberDTO(); //새로 객체 생성 
			dto.setId("new"); // 클라이언트 id == new , pw, address 등 null이 되도록
		}
		// pw맞는지 확인
		if (!dto.getPassword().equals(password)) {
			dto.setPassword("new");
			dto.setEmail(null);
			dto.setName(null);
			dto.setPhone(null);
			dto.setAddress(null);
		}
		
		
		
		// @RequestMapping은 원래 String, void, ModelAndView 타입중 하나.
		// jackson-databind: pom.xml에 자바객체를 JSon으로 자동변환하는 Dependency 추가.(jackson-databind)
		return dto; 
	}
	
	@RequestMapping(value = "/ajax/memberlist" , produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<MemberDTO> memberlist(){
		

		// dto 객체(회원정보) 10개 만들기 (가짜) 
//		List<MemberDTO> list = new ArrayList<MemberDTO>(); // List는 인터페이스. 따라서 list를 new 할 수는 없지만 부모타입으로서 타입으로는 사용가능.
//		for(int i = 1; i <= 10; i++) {
//			MemberDTO dto = new MemberDTO();
//			dto.setId("id"+i);
//			dto.setPassword(String.valueOf(i)); // int -> String 변환
//			dto.setName("이름"+i);
//			dto.setPhone("010222333"+i);
//			dto.setEmail("email"+ i + "@naver.com");
//			dto.setAddress("서울" + i);			
//			list.add(dto);
//		}
		

		// 마이바티스 
//		List<MemberDTO> = sqlsession.selectList("", 파라미터)
		// 마이바티스 연동
		List<MemberDTO> list= service.selectmember();
		
		
		return list; // List로 보내면 자바스크립트는 배열로 받음.
	}

}
