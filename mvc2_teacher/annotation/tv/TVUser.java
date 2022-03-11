package annotation.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		ApplicationContext factory
		= new ClassPathXmlApplicationContext("annotation/tv/tv.xml");
		
	//	for(String n : factory.getBeanDefinitionNames()) {
	//		System.out.println(n);	
	//	}
		

		TV tv = (TV)factory.getBean("tv");
		/* 1. id="tv" class="spring.tv.SamsungTV" �� ��ü �̹� �����Ǿ����� Ȯ��
		 * 2-1. �����Ǿ��ٸ� tv ����(id = id)
		 * 2-2. �������� �ʾƤ˴ٸ� id = new SamsungTV() ��ü ����
		 *  */
		
		if(tv != null) {
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
		}

	}

}
