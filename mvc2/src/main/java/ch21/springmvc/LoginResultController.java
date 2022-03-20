package ch21.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// /loginform에서 로그인 버튼 누르면 실행
		ModelAndView mv = new ModelAndView();
		// 입력받은 id가 spring, pw가 1234면 "정상 로그인 사용자" 결과를 뷰로 출력 <- 이것이 모델(view에 보여줘야 할 것)이고 타입은 String
		if(request.getParameter("id").equals("spring") && request.getParameter("password").equals("1234")) {
			mv.addObject("ch21_springmvc/loginresult", "정상 로그인 사용자");
		}
		else {
			mv.addObject("ch21_springmvc/loginresult", "비정상 로그인 사용자");			
		}
		
		// view 설정
		mv.setViewName("ch21_springmvc/loginresult");
		
		return mv;
	}
	
}
