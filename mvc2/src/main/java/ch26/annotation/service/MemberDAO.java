package ch26.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	MemberDTO dto;

	// @Autowired있어서 setter메서드 필요 없다. 
//	public void setDto(MemberDTO dto) {
//		this.dto = dto;
//	}

	// java application main 메서드 실행시 필요 메서드 
	public boolean selectMember(){
		if(dto.getId().equals("spring") && dto.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입 되셨습니다.");
	}
	
	// spring mvc 브라우저 입력 정보 받아서 실행시 필요 메서드 
	public boolean selectMember(MemberDTO dto){
		if(dto.getId().equals("spring") && dto.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public void insertMember(MemberDTO dto) {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입 되셨습니다.");
	}
}
