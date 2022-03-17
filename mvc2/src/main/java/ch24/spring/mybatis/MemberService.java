package ch24.spring.mybatis;

import java.util.List;

public interface MemberService {
	
	public int insertmember(MemberDTO dto);
	public int updatemember(MemberDTO dto);
	public int deletemember(String id);
	public List<MemberDTO> selectmember();
	public List<String> selectmember(String[] address);
	public List<MemberDTO> selectmember(int page);
	public MemberDTO selectmember(String id);
}
