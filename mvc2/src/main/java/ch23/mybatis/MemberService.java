package ch23.mybatis;

import java.util.List;

public interface MemberService {
	
	public int insertmember(MemberDTO dto);
	public int updatemember(MemberDTO dto);
	public int deletemember(String id);
	public List<MemberDTO> selectmember();
	public MemberDTO selectmember(String id);
	public List<MemberDTO> selectmember(int[] limit);
	public List<String> selectmember(String[] address);
}
