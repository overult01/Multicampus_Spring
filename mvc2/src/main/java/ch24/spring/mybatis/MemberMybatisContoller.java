package ch24.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisContoller {

	@Autowired
	@Qualifier("mybatisservice")
	MemberService service;
	
	// service.selecmember 전체회원 조회 메서드. -> 결과를 모델로 받고, 뷰를 mybatis/memberlist.jsp 
	@RequestMapping("/membermybatislist")
	public ModelAndView selectmember() {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = service.selectmember();
		mv.addObject("memberlist", list);
		mv.setViewName("ch24_mybatis/memberlist");
		return mv;
	}
	
	@RequestMapping("/membermybatispaginglist")
	public ModelAndView selectmember(int page) {
		ModelAndView mv = new ModelAndView();		
		List<MemberDTO> list = service.selectmember(page);
		mv.addObject("memberlist", list);
		mv.addObject("name", "페이징처리리스트"); // 전달되는 모델이 2개. name 속성에 추가.
		mv.setViewName("ch24_mybatis/memberlist");		
		return mv;
	}
	
	@RequestMapping("/membermybatisaddresslist")
	public ModelAndView selectmember(String[] address) {
		ModelAndView mv = new ModelAndView();
		List<String> list = service.selectmember(address);
		mv.addObject("memberaddresslist", list);
		mv.addObject("name", "주소검색리스트"); 
		mv.setViewName("ch24_mybatis/memberlist");				
		return mv;
	}
	
	@GetMapping("/membermybatisinsert")
	public String insertform() {
		return "ch24_mybatis/insertform";		
	}
	
	@PostMapping("/membermybatisinsert")
//	public ModelAndView insertsult(String id, String password, String name, String phone, String email, String address) {
//		MemberDTO dto = new MemberDTO(id, password, name, phone, email, address);
	public ModelAndView insertsult(MemberDTO dto) {
		// 매개변수로 MemberDTO를 주면, 값하나씩 자동으로 dto.setID(request.getParameter("id")) 해준 것과 같아진다.
		ModelAndView mv = new ModelAndView();
		int insertrow = service.insertmember(dto);
		mv.addObject("insertresult", insertrow); // int타입의 모델 1개 전달
		mv.setViewName("ch24_mybatis/insertresult");				
		return mv;
	}
	
	@GetMapping("/membermybatisupdate")
	public String updatefrom(String id) {
		return "ch24_mybatis/updateform";
	}
	
	@PostMapping("/membermybatisupdate")
	public ModelAndView updatesult(MemberDTO dto) { // id(고정), name, address입력
		// 매개변수로 MemberDTO를 주면, 값하나씩 자동으로 dto.setID(request.getParameter("id")) 해준 것과 같아진다.
		ModelAndView mv = new ModelAndView();
		int updaterow = service.updatemember(dto);
		mv.addObject("updateresult", updaterow); // int타입의 모델 1개 전달
		mv.setViewName("ch24_mybatis/updateresult");				
		return mv;
	}
	
	@RequestMapping("/membermybatisdelete")
	public String deletemember(String id) {
		// 삭제
		int deletrow = service.deletemember(id);
		if(deletrow == 1) { // 삭제되었으면 전체 회원가입 출력 
			//	redirect:컨트롤러url매핑값 -> 해당 Url의 메서드 사용. 이렇게 해서 전체 조회 
			return "redirect:/membermybatislist"; 
		}
		// 삭제 안되면 회원가입으로 넘어가기.
		return "redirect:/membermybatisinsert"; 
		
	}
}
