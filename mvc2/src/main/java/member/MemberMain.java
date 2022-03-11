package member;

public class MemberMain {

	public static void main(String[] args) {

		// non-spring
		MemberDTO dto = new MemberDTO();
		dto.setId("jsp");
		dto.setPassword("1234");
		dto.setName("홍길동");
		dto.setPhone("010-1111-2222");
		dto.setEmail("spring@io");
		dto.setAddress("서울시");
		
		MemberDAO dao = new MemberDAO();
		dao.setDto(dto); // dto를 dao에 전달
		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println("정상 로그인 사용자입니다.");
		}
		else {
			dao.insertMember();
		}
	}

}
