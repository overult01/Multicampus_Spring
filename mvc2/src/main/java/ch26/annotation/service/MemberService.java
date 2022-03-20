package ch26.annotation.service;

public interface MemberService {
	
	// java application main 실행
	void registerMember();
	void login();
	
	// spring mvc 실행
	String registerMember(MemberDTO dto);
	boolean login(MemberDTO dto);
	
}
