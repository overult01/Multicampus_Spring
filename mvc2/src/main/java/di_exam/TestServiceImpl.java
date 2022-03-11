package di_exam;

public class TestServiceImpl implements TestService{
	private TestDAO dao;

	public TestDAO getDao() {
		return dao;
	}

	public void setDao(TestDAO dao) {
		this.dao = dao;
	}

	public TestVO test() {
		System.out.println("TestServiceImpl : test() ");
		dao.test();
		return dao.getVo();
	}
}
