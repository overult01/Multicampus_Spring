package tv;

public class TVFactory {
	// 사용자의 요청을 받아서 tv객체 생성
	public tv getTV(String name) {
		if(name.equalsIgnoreCase("samsung")) {
			return new SamsungTV();
		}
		else if(name.equalsIgnoreCase("lg")) {
			return new LgTV();
		}
		else {
			return null;
		}
		
	}
}
