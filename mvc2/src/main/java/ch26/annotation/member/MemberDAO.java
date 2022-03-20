package ch26.annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDAO {
	
	@Autowired
	@Qualifier("dto3") // dto 타입 3개 중 어느 dto인지 명시 
	MemberDTO dto;

//	@Autowired 쓰면 setter안쓴다.	
//	public void setDto(MemberDTO dto) { // <property name = "dto" ..> -> @Autowired 형식으로. 이제 아무도 setter메서드를 사용하지 않는다 
//		this.dto = dto;
//	}
	
	public boolean selectMember() {
		if(dto.getId().equals("spring") && dto.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + " 회원님 정상적으로 회원가입되셨습니다.");
	}
}
