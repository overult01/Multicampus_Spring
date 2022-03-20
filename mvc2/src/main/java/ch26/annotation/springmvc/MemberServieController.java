package ch26.annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch26.annotation.service.MemberDTO;
import ch26.annotation.service.MemberService;




@Controller
public class MemberServieController {
	
	// MemberServiceImpl1사용
	@Autowired
	MemberService service;
	
	
	@RequestMapping("/memberservice")
	public ModelAndView memberservice(MemberDTO dto) {
		// 요청 파라미터 = form태그 input name = "id" == dto.setId(..)
		ModelAndView mv = new ModelAndView();
		
		// id가 spring, pw가 1234면 정상 로그인
		boolean loginresult = service.login(dto);
		String registerresult = service.registerMember(dto);
		
		mv.addObject("loginresult", loginresult);
		mv.addObject("registerresult", registerresult);
		
		mv.setViewName("memberservice");
		
		return mv;
	}
}
