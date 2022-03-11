package teacher.tv;

public class SamsungTV implements TV{
	public void powerOn() {
		System.out.println("samsungtv - ���� �Ѵ�");
	}
	public void powerOff() {
		System.out.println("samsungtv - ���� ����");
	}
	public void soundUp() {
		System.out.println("samsungtv - �Ҹ��� ���̴�");
	}
	public void soundDown() {
		System.out.println("samsungtv - �Ҹ��� ���ߴ�");
	}
}
