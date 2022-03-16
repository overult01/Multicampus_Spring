package ch19.spring.tv;

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
