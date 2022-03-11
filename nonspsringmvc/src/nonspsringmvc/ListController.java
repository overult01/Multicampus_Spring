package nonspsringmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {

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

}
