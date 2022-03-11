package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml 설정 읽어서 객체 생성 나한테 줘
		ApplicationContext factory =  new ClassPathXmlApplicationContext
				("annotation/member/member.xml");
		
		for(String n : factory.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("정상 로그인 사용자입니다");//id=spring / pw=1234
		}
		else {
			dao.insertMember();
		}
	}

}
