package memberservice_nondb;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao;
	MemberDTO dto;
	//<property name="dao"  ref="MemberDAO��ü"	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	//<property name="dto" ref="MemberDTO��ü"
	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}


	@Override
	public void registerMember() {
		int result = dao.selectMember(dto.getId(), dto.getPassword());
		if(result == 2) { dao.insertMember(dto); }
	}

	@Override
	public void login() {
		int result = dao.selectMember(dto.getId(), dto.getPassword());
		if(result == 0) {
			System.out.println("���� �α��� �����");
		}
		else {
			System.out.println("������ �����");
		}
	}

}
