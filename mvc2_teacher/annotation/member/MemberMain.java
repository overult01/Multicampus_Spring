package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml ���� �о ��ü ���� ������ ��
		ApplicationContext factory =  new ClassPathXmlApplicationContext
				("annotation/member/member.xml");
		
		for(String n : factory.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("���� �α��� ������Դϴ�");//id=spring / pw=1234
		}
		else {
			dao.insertMember();
		}
	}

}
