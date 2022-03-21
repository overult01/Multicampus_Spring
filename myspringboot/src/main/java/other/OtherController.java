package other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtherController {
	
	@RequestMapping("/other")
	public ModelAndView others() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("other1", "스프링부트 시작하기");
		mv.setViewName("first/other");
		return mv;
	}
}
