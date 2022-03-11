package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("command/command.xml");

		
//		c1.BoardCommmand 추가메서드 사용하려면 BoardCommmand타입으로 읽어오기.
// 아니라면 Command 타입으로 받아오기.	
		
		// command 타입의 객체만 저장
//		Command[] c = new Command[3];
//		c[0] = c1;
//		c[1] = c2;
//		c[2] = c3;
		
//		Command c1 = (Command)factory.getBean("board");
//		Command c2 = (Command)factory.getBean("member");
//		Command c3 = (Command)factory.getBean("product");
//
//		c[0].run();
//		c[1].run();
//		c[2].run();
		
		String[] names = factory.getBeanDefinitionNames(); // getBeanDefinitionNames(): 리턴타입은 String 
		for (String n : names) {
			Command c = (Command)factory.getBean(n); // getBean: 매개변수로 준 이름으로 가져온다. 
			c.run();
		}
	}

}
