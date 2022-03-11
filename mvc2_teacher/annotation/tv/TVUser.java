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
		/* 1. id="tv" class="spring.tv.SamsungTV" 인 객체 이미 생성되었는지 확인
		 * 2-1. 생성되었다면 tv 재사용(id = id)
		 * 2-2. 생성되이 않아ㅛ다면 id = new SamsungTV() 객체 생성
		 *  */
		
		if(tv != null) {
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
		}

	}

}
