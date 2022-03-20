package ch26.annotation.service;

public class MemberServiceImpl2 implements MemberService{
	MemberDAO dao;
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public void registerMember() {
		boolean result = dao.selectMember(); 
		if(!result) {
			dao.insertMember();
		}
		
	}

	@Override
	public void login() {
		boolean result = dao.selectMember();
		if(result) {
			System.out.println("정상 로그인 사용자");
		}
		else {
			System.out.println("비정상 로그인 사용자");
		}
		
	}
	@Override
	public String registerMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean login(MemberDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
