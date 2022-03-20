package ch26.annotation.test;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	// @RequestMapping(value = "/memberin", method = RequestMethod.GET)
	@GetMapping("/memberin")
	public String insert() {
		return "annotationtest/memberinsert";
	}
	
	// 방법1: 매개변수를 HttpServletRequest로 파라미터 읽기 
	public ModelAndView insertpost(HttpServletRequest request) throws Exception {
		
		// post방식 인코딩 
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setAddress(address);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto); // jsp에서도 dto로 접근할 수 있게 됨 
		mv.setViewName("annotationtest/member");
		
		return mv;
	}


	// 방법2: 매개변수로 읽어와야 할 값들 넣기  
	public ModelAndView insertpost(String id, String password, String name, String phone, String email, String address) {
		
//		request.setCharacterEncoding("utf-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setAddress(address);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto); // jsp에서도 dto로 접근할 수 있게 됨 
		mv.setViewName("annotationtest/member");
		
		return mv;

	}

	
	@PostMapping("/memberin")
	// 방법3: 매개변수로 자바 객체 넣기 @ModelAttribute
	public ModelAndView insertpost(@ModelAttribute("dto") MemberDTO dto) {
		
		ModelAndView mv = new ModelAndView();
		// mv.addObject("dto", dto); <- @ModelAttribute("dto") 와 같다.
		mv.setViewName("annotationtest/member");
		
		return mv;
		
	}
}
