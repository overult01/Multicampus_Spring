package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml 설정 읽어서 객체 생성 나한테 줘
		ApplicationContext factory =  new ClassPathXmlApplicationContext("memberservice/member.xml");
//		String [] names = factory.getBeanDefinitionNames();
//		for(String n : names) {
//			System.out.println(n);
//		}

		MemberService service = (MemberService)factory.getBean("service");
		service.registerMember();//servlet , 1234
		service.login();// spring, 1234 로 로그인 true 
	}

}
