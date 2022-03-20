package ch26.annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//스프링 MVC anntation 방식으로  컨트롤러 바꾸기 (controller 구현 필요 x)

@Controller
public class HelloController{

	@RequestMapping("/hello")
	public ModelAndView handleRequest(){ // 매개변수를 없앴다.(오버라이딩이 아니라서)
		// model 정의 + view 선택(nonspring MVC일 때 handleRequest메서드 변형)
		HelloDTO dto = new HelloDTO();
		dto.setMessage("hello mvc 응답 완료");
		ModelAndView mv = new ModelAndView();
		// request.setAttribute("model", dto); 대신한 문장.
		mv.addObject("model", dto); // addObject("모델명", 전달할 객체) 
		
		// view를 무조건 jsp만 쓸 거라서 .jsp 생략.
		mv.setViewName("hello");

		return mv;  
	}

	
	
	/* nonspring MVC에서 직접 만든 Controller 인터페이스 구현했을 때.
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// model 정의 + view 선택
		HelloDTO dto = new HelloDTO();
		dto.setMessage("hello mvc 응답 완료");
		request.setAttribute("model", dto);
		return "hello.jsp"; // 응답할 view 선택 
	}
	*/
	
}
