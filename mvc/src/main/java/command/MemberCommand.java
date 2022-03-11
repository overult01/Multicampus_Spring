package command;

public class MemberCommand implements Command {

	@Override
	public void run() {
		System.out.println("회원 : 관리중입니다.");
	}
	
}
