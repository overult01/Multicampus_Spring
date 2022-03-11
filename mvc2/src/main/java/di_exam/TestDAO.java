package di_exam;

public class TestDAO {
	private TestVO vo;

	public TestVO getVo() {
		return vo;
	}

	public void setVo(TestVO vo) {
		this.vo = vo;
	}
	
	public TestVO test(){
		System.out.println("TestVO : test() ");
		return vo;
	}
}
