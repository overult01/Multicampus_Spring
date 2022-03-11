package command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new
				ClassPathXmlApplicationContext("command/command.xml");
		/*Command c1 = (Command)factory.getBean("board");
		Command c2 = (Command)factory.getBean("member");
		Command c3 = (Command)factory.getBean("product");
		c1.run();
		c2.run();
		c3.run();*/
		
		String [] names = factory.getBeanDefinitionNames();
		for(String n : names) {
			Command c = (Command)factory.getBean(n);
			c.run();
		}

	}

}
