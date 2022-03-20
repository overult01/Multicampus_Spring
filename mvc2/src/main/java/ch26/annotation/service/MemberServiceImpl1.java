package ch26.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl1 implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	// Autowired 붙여서 setter필요 없다.
//	public void setMemberDAO(MemberDAO dao) {
//		this.dao = dao;
//	}
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

	// 
	@Override
	public String registerMember(MemberDTO dto) { // 브라우저에서 입력받은 사용자 정보를 매개변수 형태로 전달 
		boolean result = dao.selectMember(dto); 
		if(!result) {
			dao.insertMember(dto);
			return "회원가입 되셨습니다.";
		}
		return "회원가입할 수 없습니다.";
		
	}

	@Override
	public boolean login(MemberDTO dto) {
		boolean result = dao.selectMember(dto);
		if(result) {
			System.out.println("정상 로그인 사용자");
		}
		else {
			System.out.println("비정상 로그인 사용자");			
		}
		return result;
		
	}
	
}
