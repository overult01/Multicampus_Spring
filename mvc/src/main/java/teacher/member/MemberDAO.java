package teacher.member;

public class MemberDAO {
	MemberDTO dto;

	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}

	public boolean selectMember(){
		if(dto.getId().equals("spring") && dto.getPassword().equals("1234")) {
			return true;
		}
		return false;
	}
	
	public void insertMember() {
		System.out.println(dto.getId() + " ȸ���� ���������� ȸ�����ԵǼ̽��ϴ�.");
	}
}
