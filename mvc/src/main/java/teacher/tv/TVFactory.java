package teacher.tv;

public class TVFactory {
	//����� ��û�� �޾Ƽ�  tv��ü ����-���� 2����
	public TV getTV(String name) {
		if(name.equalsIgnoreCase("samsung")) {
			return new SamsungTV();
		}
		else if(name.equalsIgnoreCase("lg")) {
			return new LgTV();
		}
		else {
			return null;//�Ｚ apple ....
		}
	}
}
