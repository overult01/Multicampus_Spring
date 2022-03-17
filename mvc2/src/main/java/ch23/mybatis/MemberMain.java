package ch23.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(
				Resources.getResourceAsReader("mybatis/mybatis-config.xml")
				); // mybatis-config.xml파일을 읽어서 DB연결 공장을 생성 
		
		// 만들어진 커넥션 정보를 세션이라 한다. factory.openSession(true) 해줘야 db즉각 반영 
		SqlSession session = factory.openSession(true); // SqlSession == jdbc connection . 
		
		// Main이 만들어놓은 세션을 dao에게 전달해서 db연결 처리하도록.
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
		
		MemberServiceImpl service = new MemberServiceImpl();
		service.setDao(dao);
		
		// 저장. 리턴타입은 삽입한 행의 개수
		/*
		MemberDTO dto = new MemberDTO();
		dto.setId("mybatis2");
		dto.setPassword("mybatis2");
		dto.setName("홍길동");
		dto.setPhone("01900000000");
		dto.setAddress("강원도 원주시");
		int insertrow = service.insertmember(dto); // 실제 저장은 MemberServiceImpl를 거쳐 dao가 맡김.
		System.out.println(insertrow);
		*/

		// 수정
		/*
		MemberDTO dto = new MemberDTO();
		dto.setId("mybatis2");
		dto.setName("박수정");
		dto.setAddress("전주");
		// session.update("updatemember", dto); // id, name, address
		int updaterow = service.updatemember(dto); 
		System.out.println(updaterow);
		*/
		
		// 삭제
		// session.delete("deletemember", "mybatis2");
		// service.deletemember("mybatis2");

		// 전체 조회 
		/*
		// <select id = "memberlist"> 를 읽기.
//		List<MemberDTO> list = session.selectList("memberlist"); // resultType은 memberDTO였음.  레코드 1개는 MemberDTO타입.(mybastis.MemberDTO의 별명)
		List<MemberDTO> list = service.selectmember(); // resultType은 memberDTO였음.  레코드 1개는 MemberDTO타입.(mybastis.MemberDTO의 별명)
		for(MemberDTO dto2 : list) {
			System.out.println(dto2.getId() + ":" + dto2.getName() + ":" + dto2.getAddress());
		}
		*/
		
		
		// 사용자 1명만 조회
		/*
		MemberDTO onedto = service.selectmember("mybatis");
		System.out.println(onedto.getId() + ":" + onedto.getName() + ":" + onedto.getAddress());
		*/

		/*
		MemberDTO onedto = session.selectOne("member", "mybatis");
		System.out.println(onedto.getId() + ":" + onedto.getName() + ":" + onedto.getAddress());
		*/
		
		// 페이징 처리 된 조회
//		int[] limit = {5, 6}; // 5번 인덱스부터 6개만 
//		List<MemberDTO> list2 = service.selectmember(limit);
//		for(MemberDTO pagingdto : list2) {
//			System.out.println(pagingdto.getId() + ":" + pagingdto.getName() + ":" + pagingdto.getAddress());
//		}

		/*
		int[] limit = {5, 6}; // 5번 인덱스부터 6개만 
		List<MemberDTO> list = session.selectList("paginglist", limit);
		for(MemberDTO pagingdto : list) {
			System.out.println(pagingdto.getId() + ":" + pagingdto.getName() + ":" + pagingdto.getAddress());
		}
		*/
		
		// 조건 검색: in으로 조건 주기. 주소로 id조회
//		String[] address = {"광교", "전주"}; 
//		List<String> list3 = service.selectmember(address);
//		for(String s : list3) {
//			System.out.println(s);
//		}
		/*
		String[] address = {"서울", "대전"}; 
		List<String> list = session.selectList("addresssearch", address);
		for(String s : list) {
			System.out.println(s);
		}
		*/

		
		
	}
	

}
