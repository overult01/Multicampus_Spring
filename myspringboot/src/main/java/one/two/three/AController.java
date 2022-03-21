package one.two.three;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AController {
	
	@RequestMapping("/a")
	public String a() {
		return "first/sample"; // sapmple.jsp로 뷰이동 
	}
}
