package nonspsringmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 대문역할. 시작, 마무리(뷰 호출) 모두 담당.
// http://localhost:8080/nonspringmvc/*  (어떤 것이 와도 상관없다. 사용자의 모든 요청을 받아온다)
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// '/hello' 종료 url - HelloController 호출
		String uri = request.getRequestURI(); // url은 전체 주소. url: 서버 내부의 경로만. http://localhost:8080 제외하고  /nonspringmvc/hello 
		String[] uri_sp = uri.split("/"); // /가 나올 때마다 분리.
		String result = uri_sp[uri_sp.length-1]; // uri분리에서 가장 마지막 값 
		System.out.println(result);
		
		// HandlerMapping 클래스 정의 : 끝이 hello로 끝났으면, HelloController 객체를 생성
		HandlerMapping mappings = new HandlerMapping();
		Controller con = mappings.getController(result);
		String viewname = con.handleRequest(request, response); // 리턴타입은 String 
		
		// 이동 
		RequestDispatcher rd = request.getRequestDispatcher(viewname); // view로 전달 
		// 컨트롤러 내부 request.setAttribute("model", dto)
		rd.forward(request, response);
	}

}
