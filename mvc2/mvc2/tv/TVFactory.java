package tv;

public class TVFactory {
	//사용자 요청을 받아서  tv객체 생성-현재 2종류
	public TV getTV(String name) {
		if(name.equalsIgnoreCase("samsung")) {
			return new SamsungTV();
		}
		else if(name.equalsIgnoreCase("lg")) {
			return new LgTV();
		}
		else {
			return null;//삼성 apple ....
		}
	}
}
