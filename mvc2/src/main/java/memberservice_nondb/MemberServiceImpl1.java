package memberservice_nondb;

public class MemberServiceImpl1 implements MemberService{
	MemberDAO dao;
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void regiterMember() {
		boolean result = dao.selectMember(); 
		if(!result) {
			dao.insertMember();
		}
		
	}

	@Override
	public void login() {
		boolean result = dao.selectMember();
		if(result) {
			System.out.println("���� �α��� �����");
		}
		else {
			System.out.println("������ �α��� �����");			
		}
		
	}

}
