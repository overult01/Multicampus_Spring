package ch32.spring.mybatis;

import java.util.List;

public interface MemberService {
	
	public int insertmember(MemberDTO dto);
	public int updatemember(MemberDTO dto);
	public int deletemember(String id);
	public List<MemberDTO> memberlist();
	public List<String> memberlist(String[] address);
	public List<MemberDTO> memberlist(int page);
	public MemberDTO member(String id);
}
