package tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("lgtv - 전원 켜다");
	}
	public void powerOff() {
		System.out.println("lgtv - 전원 끄다");
	}
	public void soundUp() {
		System.out.println("lgtv - 소리 높이다");
	}
	public void soundDown() {
		System.out.println("lgtv - 소리 낮추다");
	}
}
