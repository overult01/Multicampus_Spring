package ch22.spring_jdbc.memberservice_nonjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml ���� �о ��ü ���� ������ ��
		ApplicationContext factory =  new ClassPathXmlApplicationContext("ch22/spring_jdbc/memberservice_nonjdbc/member.xml");
		
		MemberService service = (MemberService)factory.getBean("service");
		service.registerMember();
		service.login();
	}

}
