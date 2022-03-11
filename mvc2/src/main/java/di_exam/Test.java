package di_exam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// xml으로 설정
public class Test {
	public static void main(String[] args) {
//			TestServiceImpl ts = new TestServiceImpl();

		// 스프링을 사용하면 set을 메인에서 할 필요가 없어진다. 메인은 정해진대로 받아오기만 하면 된다(제어의 역전)
//			TestDAO dao = new TestDAO();
//			ts.setDao(dao);
//			TestVO vo = new TestVO();
//			vo.setMember1("test1");
//			vo.setMember2("test2");
//			dao.setVo(vo);
//			
//			vo = ts.test();
//			System.out.println(vo.getMember1() + " : " + vo.getMember2());
		
		ApplicationContext factory 
		= new ClassPathXmlApplicationContext("di_exam/test.xml"); // ClassPathXmlApplicationContext: 자바 공간안에. // 3개 객체 생성(di)
		
		TestService ts = (TestService)factory.getBean("testservice"); // testservice는 testdao를 전달받고, testdao는 testvo를 전달받으므로 이 객체 1개만 호출하면 3개 호출된다.
		TestVO vo = ts.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());
	}
}
