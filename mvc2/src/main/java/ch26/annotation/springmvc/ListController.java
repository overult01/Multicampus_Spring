package ch26.annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//스프링 MVC anntation 방식으로  컨트롤러 바꾸기 (controller 구현 필요 x)

@Controller
public class ListController{

	@RequestMapping("/list")
	// 오버라이딩이 아니어서 handleRequest메서드를 자유롭게 변경
	public ModelAndView list() throws Exception {
		// model 정의 + view 선택(nonspring MVC일 때 handleRequest메서드 변형)

		// model
		ArrayList<HelloDTO> list = new ArrayList<HelloDTO>();

		HelloDTO d1 = new HelloDTO();
		d1.setMessage("리스트1");

		HelloDTO d2 = new HelloDTO();
		d2.setMessage("리스트2");

		HelloDTO d3 = new HelloDTO();
		d3.setMessage("리스트3");

		list.add(d1);
		list.add(d2);
		list.add(d3);
		
		// request.setAttribute("dtolist", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("dtolist", list);
		// view(.jsp 확장자는 생략. 뷰는 무조건 jsp이므로)
		mv.setViewName("list");
		
		return mv;

	
	}

	/* nonspring MVC에서 직접 만든 Controller 인터페이스 구현했을 때.
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// model
		ArrayList<HelloDTO> list = new ArrayList<HelloDTO>();

		HelloDTO d1 = new HelloDTO();
		d1.setMessage("리스트1");

		HelloDTO d2 = new HelloDTO();
		d2.setMessage("리스트2");

		HelloDTO d3 = new HelloDTO();
		d3.setMessage("리스트3");

		list.add(d1);
		list.add(d2);
		list.add(d3);
		
		request.setAttribute("dtolist", list);
		// view
		return "list.jsp";
	}
	*/

}
