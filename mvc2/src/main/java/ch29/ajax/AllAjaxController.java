package ch29.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch24.spring.mybatis.MemberDTO;

// sts 4버전 이상에서만 사용가능 
@RestController // ajax전용 컨트롤러: 모든 요청을 ajax로 받고, ajax처리를 하는 어노테이션.
// 각 메서드에서는 @ResponseBody를 빼고.
public class AllAjaxController {

	// 모든 메서드가 ajax 요청받아서 ajax처리하는 예제 
	
	@RequestMapping("/ajax/a")
	// @ResponseBody
	public String a() {
		return "{\"result\":true}"; // String 리턴할 수 있도록.
	}

	@RequestMapping("/ajax/b")
	// @ResponseBody
	public MemberDTO b() {
		return new MemberDTO("ID", "PASSWORD"); // id, password외의 값은 안줘서 null
	}
	
	@RequestMapping("/ajax/c")
	// @ResponseBody	
	public String[] c() {
		return new String[] {"a", "b", "c"}; // ["a","b","c"] 반환. json형식.
	}
	
}
