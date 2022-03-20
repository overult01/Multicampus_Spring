package ch26.annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController{

	// @RequestMapping("/loginform")
	// 오버라이딩이 아니어서 handleRequest메서드를 자유롭게 변경(리턴타입도 String으로 변경. 스프링에서 @RequestMapping이 붙어있는 메서드의 리턴타입이 String이면 뷰 이름으로 인식.)
	public String loginform() throws Exception {
		return "loginform";
	}

}
