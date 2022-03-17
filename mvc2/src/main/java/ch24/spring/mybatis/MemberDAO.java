package ch24.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mybatisdao")
public class MemberDAO {
	
	@Autowired
	SqlSession session;
	
	// 저장. 리턴타입은 삽입한 행의 개수
	public int insertmember(MemberDTO dto) {
		int insertrow = session.insert("insertmember", dto);
		return insertrow;		
	}	
	/*
	MemberDTO dto = new MemberDTO();
	dto.setId("mybatis2");
	dto.setPassword("mybatis2");
	dto.setName("홍길동");
	dto.setPhone("01900000000");
	dto.setAddress("강원도 원주시");
	int insertrow = session.insert("insertmember", dto);
	System.out.println(insertrow);
	*/

	// 수정
	public int updatemember(MemberDTO dto) {
		return session.update("updatemember", dto); // id, name, address
	}
	/*
	MemberDTO dto = new MemberDTO();
	dto.setId("mybatis");
	dto.setName("이수정");
	dto.setAddress("대전");
	session.update("updatemember", dto); // id, name, address
	*/
	
	// 삭제
	public int deletemember(String id) {
		return session.delete("deletemember", id);
	}
	// session.delete("deletemember", "mybatis2");
	
	// 전체 조회
	public List<MemberDTO> selecmember() {
		List<MemberDTO> list = session.selectList("memberlist"); // resultType은 memberDTO였음.  레코드 1개는 MemberDTO타입.(mybastis.MemberDTO의 별명)
		return list;
	}
	// <select id = "memberlist"> 를 읽기.
	/*
	List<MemberDTO> list = session.selectList("memberlist"); // resultType은 memberDTO였음.  레코드 1개는 MemberDTO타입.(mybastis.MemberDTO의 별명)
	for(MemberDTO dto2 : list) {
		System.out.println(dto2.getId() + ":" + dto2.getName() + ":" + dto2.getAddress());
	}
	*/
	
	/*
	MemberDTO onedto = session.selectOne("member", "mybatis");
	System.out.println(onedto.getId() + ":" + onedto.getName() + ":" + onedto.getAddress());
	*/
	
	// 페이징 처리 된 조회
	public List<MemberDTO> selectmember(int page) {
		int[] limit = new int[] {(page-1)*5, 5}; // 사용자가 지정한 페이지수부터 5게 츨략.
		List<MemberDTO> list = session.selectList("pagingorderlist", limit);
		return list;		
	}
	/*
	int[] limit = {5, 6}; // 5번 인덱스부터 6개만 
	List<MemberDTO> list = session.selectList("paginglist", limit);
	for(MemberDTO pagingdto : list) {
		System.out.println(pagingdto.getId() + ":" + pagingdto.getName() + ":" + pagingdto.getAddress());
	}
	*/
	
	// 조건 검색: in으로 조건 주기. 주소로 id조회
	public List<String> selectmember(String[] address){
		List<String> list = session.selectList("addresssearch", address);
		return list;
	}
	/*
	String[] address = {"서울", "대전"}; 
	List<String> list = session.selectList("addresssearch", address);
	for(String s : list) {
		System.out.println(s);
	}
	*/
	
	// 사용자 1명만 조회
	public MemberDTO selectmember(String id) {
		MemberDTO dto = session.selectOne("member", id);
		return dto;
	}
}
