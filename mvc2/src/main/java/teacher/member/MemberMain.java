package teacher.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml ���� �о ��ü ���� ������ ��
		ApplicationContext factory =  new ClassPathXmlApplicationContext("member/member.xml");
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("���� �α��� ������Դϴ�");//spring / 1234
		}
		else {
			dao.insertMember();
		}
	}

}
