package ch19.spring.tv;

public class LgTV implements tv{
	
	public LgTV() {
		super();
		System.out.println("lgtv - 생성자 호출");		
	}
	
	public void soundUp() {
		System.out.println("lgtv - 소리를 높이다");
	}
	public void soundDown() {
		System.out.println("lgtv - 소리를 낮추다");
	}
	@Override
	public void powerOn() {
		System.out.println("lgtv - 전원 켜다");
		
	}
	@Override
	public void powerOff() {
		System.out.println("lgtv - 전원 끄다");
		
	}

}
