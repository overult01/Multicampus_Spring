package ch21.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// /loginform입력시 loginformController 호출되어 실행 
		ModelAndView mv = new ModelAndView(); // c -> m이 없음 -> v 호출
		// mv.addObject("", );
		mv.setViewName("ch21_springmvc/loginform");
		return mv;
	}

}
