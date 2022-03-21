package ch32.upload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 현재 파일을 웹 설정 파일에 포함한다는 뜻. mvc의 <resources.. 에 해당 
@Configuration
public class MeyWebConfig implements WebMvcConfigurer {


	// 외부경로 파일보여줄 url설정하기(현재 부트프로젝트 외부에 있는 파일을 브라우저 url로 접근)
	// //http://localhost:8081/upload/images/drinks.jpg 로 url접근할 수 있게 하기 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		
		// 정적파일(이미지)은 기본적으로 프로젝트 내부의 static폴더 밑에,
		// 외부 정적파일을 보여주려면 이 예시처럼 url 설정추가.
		
		// mvc프로젝트의 	<resources mapping="/resources/**" location="/resources/" /> 대신 

		registry
		.addResourceHandler("/upload/**") // url에서는 upload라고 쓰겠다. upload의 모든 파일.
		.addResourceLocations("file:///Users/jungmin/Desktop/kdt-venture/workspace/spring/upload/"); // 실제 경로는 이렇다.
	}

}
