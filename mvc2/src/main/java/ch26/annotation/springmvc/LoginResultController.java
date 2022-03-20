package ch26.annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginResultController{

	// @RequestMapping("/loginresult")
	// 오버라이딩이 아니어서 handleRequest메서드를 자유롭게 변경
	public ModelAndView loginresult(HttpServletRequest request){
		
		// /loginform에서 로그인 버튼 누르면 실행
		ModelAndView mv = new ModelAndView();
		// 입력받은 id가 spring, pw가 1234면 "정상 로그인 사용자" 결과를 뷰로 출력 <- 이것이 모델(view에 보여줘야 할 것)이고 타입은 String
		if(request.getParameter("id").equals("spring") && request.getParameter("password").equals("1234")) {
			mv.addObject("loginresult", "정상 로그인 사용자");
		}
		else {
			mv.addObject("loginresult", "비정상 로그인 사용자");			
		}
		
		// view 설정
		mv.setViewName("loginresult");
		
		return mv;
	}
	
	// 다른 메서드도 추가 가능
//	@RequestMapping("/a")
	
}
