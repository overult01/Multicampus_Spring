package annotation.service;

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
			System.out.println("정상 로그인 사용자");
		}
		else {
			System.out.println("비정상 로그인 사용자");			
		}
		
	}

}
