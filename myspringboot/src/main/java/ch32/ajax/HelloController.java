package ch32.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
@RequestMapping("/helloboot")
public ModelAndView hello() {
	ModelAndView mv= new ModelAndView();
	mv.addObject("model", "헬로우부트프로젝트");
	mv.setViewName("ch32_ajax/hello"); // helloController 에서 뷰 요청 -> 뷰에서 ajax요청 -> ajax컨트롤러에서 응답 -> 클라이언트(뷰)에서 ajax결과 수신 후 브라우저 출력 
	return mv;
}
	
}
