package command;

public class ProductCommand implements Command {

	@Override
	public void run() {
		System.out.println("상품정보 : 관리중입니다.");
	}
	
}
