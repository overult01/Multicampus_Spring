package ch26.annotation.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TVUser {
// 커플링(의존도) 높다. 한 부분이 바뀌면 나머지 부분이 변경되어야 하는 경우.
	public static void main(String[] args) {
		// ApplicationContext : 공장역할. 객체에 대한 모든 관리를 스프링 공장에게 맡긴다.
		ApplicationContext factory
		= new ClassPathXmlApplicationContext("annotation/tv/tv.xml"); // tv.xml설정에 따라서만 tv를 만들어달라 
		// 메인 스스로 new 하지 않고, 스프링 공장의 도움을 받아서 공장에서 객체를 생성한다.
		
		
		for(String n : factory.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		// tv
		// tv2
		
		
		// @Component("tv") 되어있는 lgtv를 가져온다. 
		tv tv = (tv)factory.getBean("tv"); // bean자바객체 = 기본 생성자 호출
		// 1. id = "tv" class = "spring.tv.SamsungTV"인 객체가 이미 생성되었는지 확인
		// 2-1. 생성되었다면 tv재사용
		// 2-1. 생성되지 않았다면 id = new SamsungTV() 객체 생성 		
		
		
		if(tv != null) {
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
			
		}		
	}

}
