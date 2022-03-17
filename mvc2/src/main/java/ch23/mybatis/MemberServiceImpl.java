package ch23.mybatis;

import java.util.List;

public class MemberServiceImpl implements MemberService {

	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public int insertmember(MemberDTO dto) {
		return dao.insertmember(dto);
	}

	@Override
	public int updatemember(MemberDTO dto) {
		return dao.updatemember(dto);
	}

	@Override
	public int deletemember(String id) {
		return dao.deletemember(id);
	}

	@Override
	public List<MemberDTO> selectmember() {
		return dao.selecmember();
	}

	@Override
	public MemberDTO selectmember(String id) {
		return dao.selectmember(id);
	}

	@Override
	public List<MemberDTO> selectmember(int[] limit) {
		return dao.selectmember(limit);
	}

	@Override
	public List<String> selectmember(String[] address) {
		return dao.selectmember(address);
	}

}
