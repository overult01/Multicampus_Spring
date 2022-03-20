package ch26.annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Autowired, Qualified 어노테이션 예제 
public class MemberMain2 {

	public static void main(String[] args) {

		// spring
		// member.xml 설정 읽어서 객체 생성하고 전달받는다
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
		
		for (String n : factory.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		
		MemberDTO dto = (MemberDTO)factory.getBean("dto"); // factory.getBean("dto") 까지는 Object타입이라서 형변환 필요.
		
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("정상 로그인 사용자입니다.");
		}
		else {
			dao.insertMember();
		}
	}

}
