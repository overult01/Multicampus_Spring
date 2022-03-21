package ch32.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // 마이바티스 sql실행(id, resulttype, parameter타입). sql 매핑 파일과 동일한 메서드
@Repository("mybatisdao")
public interface MemberDAO {
	
	// 메서드 이름 == sql-mapping.xml의 id 
	
	// 저장. 리턴타입은 삽입한 행의 개수
	public int insertmember(MemberDTO dto);

	// 수정
	public int updatemember(MemberDTO dto);
	
	// 삭제
	public int deletemember(String id);
	
	// 전체 조회
	public List<MemberDTO> memberlist();
	
	// 페이징 처리 된 조회
	public List<MemberDTO> pagingorderlist(int[] limit);
	
	// 조건 검색: in으로 조건 주기. 주소로 id조회
	public List<String> addresssearch(String[] address);
	
	// 사용자 1명만 조회
	public MemberDTO member(String id);
}
