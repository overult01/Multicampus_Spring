package spring.mybatis.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productservice")
	ProductService service;
	
	// 전체 리스트조회 
	@RequestMapping("/productlist")
	public ModelAndView productlist() {
		ModelAndView mv = new ModelAndView();
		// sql 메서드 호출 순서(mvc) : 컨트롤러 호출 -> serviceImpl 호출 -> dao호출 -> sql 매퍼 
		// sql 메서드 호출 순서(부트) : 컨트롤러 호출 -> serviceImpl 호출 -> dao호출(dao메서드 이름 == sql 매퍼 이름), dao는 인터페이스 -> sql 매퍼 
		List<ProductDTO> list = service.productlist();
		mv.addObject("productlist", list);
		mv.setViewName("ch32_mybatis/productlist");
		return mv;
	}
	
	@RequestMapping("/product")
	public ModelAndView product(int code) {

		ModelAndView mv = new ModelAndView();
		// sql 메서드 호출 순서(mvc) : 컨트롤러 호출 -> serviceImpl 호출 -> dao호출 -> sql 매퍼 
		// sql 메서드 호출 순서(부트) : 컨트롤러 호출 -> serviceImpl 호출 -> dao호출(dao메서드 이름 == sql 매퍼 이름), dao는 인터페이스 -> sql 매퍼 
		ProductDTO dto = service.product(code);
		mv.addObject("productdto", dto);
		mv.setViewName("ch32_mybatis/product");

		return mv;
	}
}
