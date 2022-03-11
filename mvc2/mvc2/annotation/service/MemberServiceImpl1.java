package annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl1 implements MemberService{
	@Autowired
	MemberDAO dao;
	
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
