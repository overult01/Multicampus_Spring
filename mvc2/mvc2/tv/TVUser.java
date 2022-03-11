package tv;

public class TVUser {
//커플링 높다. 의존도 높다. - 코드 따라서 같이 수정 부분 많다
	// 모든 프로그램 = 여러개 클래스 작성 / 클래스관계 느슨한 관계
	public static void main(String[] args) {
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV(args[0]);
		if(tv != null) {
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
		}
	}

}
