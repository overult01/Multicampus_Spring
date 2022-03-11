package teacher.spring.tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("lgtv - ���� �Ѵ�");
	}
	public void powerOff() {
		System.out.println("lgtv - ���� ����");
	}
	public void soundUp() {
		System.out.println("lgtv - �Ҹ� ���̴�");
	}
	public void soundDown() {
		System.out.println("lgtv - �Ҹ� ���ߴ�");
	}
}
