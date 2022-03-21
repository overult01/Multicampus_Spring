package ch32.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 수정 필요

//@Controller
@RestController // 현재 클래스내 모든 메서드를 ajax로. (개별 메서드의 @ResponseBody 대체)
public class AjaxController {

//	@ResponseBody
	@RequestMapping("/helloajax")
	public MemberDTO test() {
		return new MemberDTO("ID1", "PASSWORD1"); // 자바객체-> json으로 자동변환(스프링부트에 내장)
	}

}
