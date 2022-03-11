package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDAO {
	@Autowired
	@Qualifier("dto1")
	MemberDTO dto;

	//public void setDto(MemberDTO dto) {//<property ame="dto" ...>--> @Autowired
	//	this.dto = dto;
	//}

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
