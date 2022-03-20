package memberservice_nondb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml ���� �о ��ü ���� ������ ��
		ApplicationContext factory =  new ClassPathXmlApplicationContext("memberservice/member.xml");
		
		MemberService service = (MemberService)factory.getBean("service");
		service.regiterMember();
		service.login();
	}

}
