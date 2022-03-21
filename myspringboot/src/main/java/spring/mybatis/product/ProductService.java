package spring.mybatis.product;

import java.util.List;

public interface ProductService {
	
	public List<ProductDTO> productlist(); // 매핑 sql id와 반드시 동일할 필요는 없다(권장). **dao 메서드 == sql id
	public ProductDTO product(int code);
}
