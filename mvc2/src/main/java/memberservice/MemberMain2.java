package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain2 {

	public static void main(String[] args) {

		// spring
		// member.xml 설정 읽어서 객체 생성하고 전달받는다
		ApplicationContext factory = new ClassPathXmlApplicationContext("memberservice/member.xml");
		String[] names = factory.getBeanDefinitionNames();
		for(String n : names) {
			System.out.println(n);
		}
		
//		MemberService service = (MemberService)factory.getBean("service");
//		service.registerMember(); // id: servlet, pw: 1234
//		service.login(); // id: spring, pw: 1234로 로그인시에만 true
	}

}
