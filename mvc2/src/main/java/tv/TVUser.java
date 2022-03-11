package tv;

public class TVUser {
// 커플링(의존도) 높다. 한 부분이 바뀌면 나머지 부분이 변경되어야 하는 경우.
	public static void main(String[] args) {
		
		TVFactory factory = new TVFactory();
		tv tv = factory.getTV(args[0]); 
		if(tv != null) {
			tv.powerOn();
			tv.soundUp();
			tv.soundDown();
			tv.powerOff();
			
		}
	}

}
