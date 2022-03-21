package spring.mybatis.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("productdao")
@Mapper
public interface ProductDAO {

	// 인터페이스의 모든 메서드는 안붙여도 자동으로 abstract, public.
	public List<ProductDTO> productlist();

	public ProductDTO product(int code);
	
}
