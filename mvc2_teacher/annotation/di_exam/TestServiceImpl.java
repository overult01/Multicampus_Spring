package annotation.di_exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testservice")
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDAO dao;

	public TestDAO getDao() {
		return dao;
	}

	public TestVO test() {
		System.out.println("TestServiceImpl : test() ");
		dao.test();
		return dao.getVo();
	}
}
