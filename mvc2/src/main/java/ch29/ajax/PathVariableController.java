package ch29.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@PathVariable 예제 : url 경로 안에 있는 변수. 위에서  값을 파라미터가 아니라 아예 url에 합치기.(뒤가 동적으로 바뀐다)
// ajax에서만 쓰이는 건 아니다.

@Controller
public class PathVariableController {

	@RequestMapping("/get/{id}") // url의 {} 가 동적으로 바뀜 
	public ModelAndView getMember(@PathVariable("id") String id) {
		System.out.println(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("ch29_ajax/path"); // 뷰는 path.jsp
		return mv; 
	}
}
