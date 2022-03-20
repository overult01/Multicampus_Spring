package ch26.annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// loginform, loginresult 한 번에 1개의 컨트롤러에서 처리 
@Controller
public class LoginAllController {

	// test4
	@GetMapping("/login")
	public String loginform(){
		return "loginform";
	}
	
	// test4 매개변수를 자바 객체로 설정 	
	@PostMapping("/login")
	public ModelAndView loginresult(@ModelAttribute("dto") LoginDTO dto) { // dto 객체 내부의 변수와 요청 파라미터 이름 id 세터, password 세터
		
//		아래 문장과 똑같은 역할  
//		dto.setId(request.getParameter("id"));
//		dto.setPw(request.getParameter("password"));		
		ModelAndView mv = new ModelAndView();
		
		if(dto.getId().equals("spring")&& dto.getPassword().equals("1234")) { // id 와 request.getParameter("id")는 같다.
			mv.addObject("loginresult", "정상 로그인 사용자");
	//		mv.addObject("userid", dto.getId());
	//		mv.addObject("userpassword", dto.getPw());
			// jsp는 el로 ${userid} 로 읽을 수 있는데, 이걸 안해도 이미 읽을 수 있다.
		}
		else {
			mv.addObject("loginresult", "비정상 로그인 사용자");						
		}

		// mv.addObject("dto", dto); 문장과 @ModelAttribute("dto") 는 같다.
		// 뷰에서는 ${dto.id} 로 가져와야 한다.
		
		mv.setViewName("loginresult"); // 뷰 내부로는 LoginDTO객체가 자동 전달된다. ${클래스이름인데 첫문자는 소문자}. 즉 ${loginDTO.id}
		
		return mv;
	}

	
	
	
	/* test3 - 컨트롤러 메서드의 매개변수  @RequestParam
	@GetMapping("/login")
	public String loginform(){
		return "loginform";
	}
	
	@PostMapping("/login")
	public ModelAndView loginresult(@RequestParam("id1") String id, @RequestParam("pw") String password, int age, String[] hobby){ // input태그의 name속성과 같으면 가져올 수 있다. 매개변수로 받아오면 request.getParameter와 같은 역할을 한다.

		// <select multiple>, <input type = checkbox> 등에서 여러값 가져올 때.
		// String[] hobby = request.getParameterValues("hobby");
		
		// int받기 
		// age = Integer.parseInt(request.getParameter("age")) 와 매개변수 int age와 같은 것.
		
		ModelAndView mv = new ModelAndView();
//		if(request.getParameter("id").equals("spring") && request.getParameter("password").equals("1234")) {
//			mv.addObject("loginresult", "정상 로그인 사용자");
//		}
//		else {
//			mv.addObject("loginresult", "비정상 로그인 사용자");			
//		}
		
		
		if(id.equals("spring")&& password.equals("1234")) { // id 와 request.getParameter("id")는 같다.
			mv.addObject("loginresult", "정상 로그인 사용자");
		}
		else {
			mv.addObject("loginresult", "비정상 로그인 사용자");						
		}
		System.out.println(age-1);
		System.out.println(hobby[0]);
		System.out.println(hobby[1]);
		System.out.println(hobby[2]);
		
		mv.addObject("age", age - 1);
		mv.setViewName("loginresult");
		
		return mv;
	}
	*/
	
	
/* test2 - http 요청 메서드 방식에 따라서 구분해서 실행 
// 	@RequestMapping(value = "/login", method = RequestMethod.GET )
	@GetMapping("/login")
	// 오버라이딩이 아니어서 handleRequest메서드를 자유롭게 변경(리턴타입도 String으로 변경. 스프링에서 @RequestMapping이 붙어있는 메서드의 리턴타입이 String이면 뷰 이름으로 인식.)
	public String loginform(){
		return "loginform";
	}
	
// <form action = "login" method = "post"> 를 해야만 post방식이다.	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
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
	*/
	
	/* test1
	@RequestMapping("/loginform")
	// 오버라이딩이 아니어서 handleRequest메서드를 자유롭게 변경(리턴타입도 String으로 변경. 스프링에서 @RequestMapping이 붙어있는 메서드의 리턴타입이 String이면 뷰 이름으로 인식.)
	public String loginform() throws Exception {
		return "loginform";
	}
	
	@RequestMapping("/loginresult")
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
	*/
}
