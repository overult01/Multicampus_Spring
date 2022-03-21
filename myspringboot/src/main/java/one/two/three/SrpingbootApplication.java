package one.two.three;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ch32.ajax.AjaxController;
import ch32.spring.mybatis.MemberDAO;
import ch32.spring.mybatis.MemberMybatisContoller;
import ch32.upload.UploadController;
import other.OtherController;
import spring.mybatis.product.ProductController;
import spring.mybatis.product.ProductDAO;

// 스프링 부트 시작점으로써, componentScan, MapperScan 붙인다.

@SpringBootApplication
@ComponentScan // 필수. 같은 패키지내라도 컨트롤러가 있다는 것 명시해줘야.
@ComponentScan(basePackageClasses = OtherController.class)
@ComponentScan(basePackageClasses =	UploadController.class)
//@ComponentScan(basePackages =	{"ch37.upload"}) -> 이렇게 패키지명을 줘도 된다. 같은 결과
@ComponentScan(basePackageClasses =	AjaxController.class)
@ComponentScan(basePackageClasses = MemberMybatisContoller.class)
@ComponentScan(basePackageClasses = ProductController.class)

@MapperScan(basePackageClasses = ProductDAO.class) 
@MapperScan(basePackageClasses = MemberDAO.class)  // @mapper 에 대한 스캔도 따로.
public class SrpingbootApplication { // 스프링부트 시작파일 

	public static void main(String[] args) {
		
		SpringApplication.run(SrpingbootApplication.class, args);
		System.out.println("====스프링부트 실행중====");
	}

}
