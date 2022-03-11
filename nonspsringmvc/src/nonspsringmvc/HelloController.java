package nonspsringmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// model 정의 + view 선택
		HelloDTO dto = new HelloDTO();
		dto.setMessage("hello mvc 응답 완료");
		request.setAttribute("model", dto);
		return "hello.jsp"; // 응답할 view 선택 
	}

}
