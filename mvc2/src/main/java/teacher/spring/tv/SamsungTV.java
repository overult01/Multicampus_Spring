package teacher.spring.tv;

public class SamsungTV implements TV{
	public SamsungTV() {
		System.out.println("�Ｚtv ������ ȣ��");
	}
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
