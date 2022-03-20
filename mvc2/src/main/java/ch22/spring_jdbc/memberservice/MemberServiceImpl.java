package ch22.spring_jdbc.memberservice;

public class MemberServiceImpl implements MemberService {

	MemberDAO dao;
	MemberDTO dto;
	
	// <property name = "dao" <-- setDao호출 value="객체외"나 ref="객체" />
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}


	@Override
	public void registerMember() {
		int result = dao.selectMember(dto.getId(), dto.getPassword());
		if(result == 2) { // id가 없다: 가입할 수 있다 
			dao.insertMember(dto);
		}
	}

	@Override
	public void login() {
		int result = dao.selectMember(dto.getId(), dto.getPassword());
		if(result == 0) {
			System.out.println("정상 로그인 사용자");
		}
		else {
			System.out.println("비정상 사용자");
		}
	}

}
