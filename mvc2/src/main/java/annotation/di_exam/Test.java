package annotation.di_exam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// 어노테이션으로 설정
public class Test {
	public static void main(String[] args) {
		
		// main은 바꿀 것이 없다. 
		ApplicationContext factory 
		= new ClassPathXmlApplicationContext("annotation/di_exam/test.xml"); // ClassPathXmlApplicationContext: 자바 공간안에. // 3개 객체 생성(di)
		
		TestService ts = (TestService)factory.getBean("testservice"); // testservice는 testdao를 전달받고, testdao는 testvo를 전달받으므로 이 객체 1개만 호출하면 3개 호출된다.
		TestVO vo = ts.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());
	}
}
