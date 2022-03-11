package annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	MemberDTO dto;

	public boolean selectMember(){
		if(dto.getId().equals("spring") && dto.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입되셨습니다.");
	}
}
