package spring.mybatis.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productservice")
public class ProductServicImpl implements ProductService {

	@Autowired
	@Qualifier("productdao")
	ProductDAO dao;
	
	@Override
	public List<ProductDTO> productlist() {
		return dao.productlist();
	}

	@Override
	public ProductDTO product(int code) {
		return dao.product(code);
	}

}
