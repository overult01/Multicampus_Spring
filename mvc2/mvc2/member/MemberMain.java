package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		//spring
		// member.xml 설정 읽어서 객체 생성 나한테 줘
		ApplicationContext factory =  new ClassPathXmlApplicationContext("member/member.xml");
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("정상 로그인 사용자입니다");//spring / 1234
		}
		else {
			dao.insertMember();
		}
	}

}
