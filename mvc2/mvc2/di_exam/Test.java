package di_exam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("di_exam/test.xml");//3°³°´Ã¼»ý¼º.di
		TestService ts = (TestService)factory.getBean("testservice");
		TestVO vo = ts.test();
		System.out.println(vo.getMember1() + ":" + vo.getMember2());

	}
}
