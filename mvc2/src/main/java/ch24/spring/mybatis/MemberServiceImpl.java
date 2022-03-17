package ch24.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mybatisservice")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("mybatisdao")
	MemberDAO dao;

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
	public List<MemberDTO> selectmember(int page) {		
		return dao.selectmember(page);
	}

	@Override
	public List<String> selectmember(String[] address) {
		return dao.selectmember(address);
	}

	@Override
	public MemberDTO selectmember(String id) {
		return dao.selectmember(id);
	}
}
