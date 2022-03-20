package ch26.annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러의 리턴타입 3가지: ModelAndView, String, void 
// 컨트롤러는 일반 클래스(extends HttpServlet... 이 없으므로)
// 뷰는 무조건 있다.

@Controller
public class ReturnTypeController {
	
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "컨트롤러에서 전달하는 모델입니다.");
		mv.setViewName("aa"); // aa.jsp호출(모델값 있다) <- 만약 뷰를 명시적으로 지정하지 않으면 Url매핑값과 같은 것으로 뷰 자동설정된다.
		
		return mv;
	}
	
	@RequestMapping("/b")
	public String b() { // 요청하는 파라미터를 dto에 저장할게 -> view에 전달할 때는 memberDTO로 전달.
		// 전달해줄 모델 없어도 된다 or 매개변수로 객체를 전달한다 
		
		// 뷰만 리턴할 것
		return "bb";
	}

	@RequestMapping("/c")
	public void cc() {
		// 모델 없어도 된다 
		// 뷰는 있어야 한다(ajax요청만 뷰 없어도 된다)
		// void타입 리턴이거나, 뷰 이름을 명시적으로 지정하지 않으면: url매핑값을 기반으로 c.jsp로 자동으로 설정된다.
	}
	
	@RequestMapping("/d")
	public String d() {
		// 모델 없는 경우
		return "aa"; // a로 끝나는 Url, d로 끝나는 url모두 공통으로 aa.jsp 뷰를 사용. but d로 요청했을 때만 모델값이 안보인다.(모델을 전달하는 건 /a뿐)
	}
	
	@RequestMapping("/e")
	public String e() { // /a에 매핑되어진 메서드를 호출
		// 다른 컨트롤러의 메서드 호출. redirect는 다시 호출이라는 뜻. 여기선 /a를 다시 호출해달라는 의미이다.
		return "redirect:/a"; 
	}
}
