package ch26.annotation.tv;

import org.springframework.stereotype.Component;

// 빈(객체)으로 만들어달라는 선언. new SamsungTV()한 것과 같다.
// @Component 로 변수명을 안주면 클래스이름에서 첫문자만 소문자로 변경해서 이름이 주어진다.(samsungTV)
@Component("tv")
public class SamsungTV implements tv {
	
	public SamsungTV() {
		System.out.println("삼성tv 생성자 호출");
	}
	
	public void powerOn() {
		System.out.println("samsungtv - 전원 켜다");
	}
	public void powerOff() {
		System.out.println("samsungtv - 전원 끄다");
	}
	public void	soundUp() {
		System.out.println("samsungtv - 소리를 높이다");
	}
	public void soundDown() {
		System.out.println("samsungtv - 소리를 낮추다");
	}

}
