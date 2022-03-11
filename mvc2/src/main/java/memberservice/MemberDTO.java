package memberservice;

public class MemberDTO {
	String id, password, name, phone, email, address;

	// 기본 생성자 자동 정의(아무 생성자도 없을 때 자동 정의)  
	MemberDTO(){super();}
	
//	<bean id = "변수명" class ="패키지명.클래스명">
//	할 때, 스프링은 기본 생성자를 호출해서 객체를 생성한다. 따라서 항상 기본생성자는 반드시 정의. 빈태그는 기본 생성자를 호출.

	MemberDTO(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	
	
	public MemberDTO(String id, String password, String name, String phone, String email, String address) {
	super();
	this.id = id;
	this.password = password;
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.address = address;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
