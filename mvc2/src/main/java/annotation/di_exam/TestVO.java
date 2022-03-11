package annotation.di_exam;

// 이미 xml에서 bean태그로 객체로 만들어 둠. 따라서 어노테이션 불필요
public class TestVO {
	private String member1;
	private String member2;
	public String getMember1() {
		return member1;
	}
	public void setMember1(String member1) {
		this.member1 = member1;
	}
	public String getMember2() {
		return member2;
	}
	public void setMember2(String member2) {
		this.member2 = member2;
	}
}
