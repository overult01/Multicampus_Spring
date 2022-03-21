package ch32.spring.mybatis;

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
	public List<MemberDTO> memberlist() {
		return dao.memberlist();
	}

	@Override
	public List<MemberDTO> memberlist(int page) {		
		int limit[] = new int[2];
		limit[0] = (page-1)*5;
		limit[1] = 5;
		return dao.pagingorderlist(limit);
	}

	@Override
	public List<String> memberlist(String[] address) {
		return dao.addresssearch(address);
	}

	@Override
	public MemberDTO member(String id) {
		return dao.member(id);
	}
}
