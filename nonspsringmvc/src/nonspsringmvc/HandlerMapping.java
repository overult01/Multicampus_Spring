package nonspsringmvc;

import java.util.HashMap;

public class HandlerMapping {
	
	HashMap<String, Controller> mappings;
	HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// url이 늘어날 수록 put만 해주면 된다. 
		mappings.put("hello", new HelloController()); // hello일 때 HelloController를 만들어주자
		mappings.put("list", new ListController());
	}
	
	// 외부로부터 필요한 객체를 전달받자.
	public Controller getController(String key) {
		return mappings.get(key); // return타입은 컨트롤러
	}

}
