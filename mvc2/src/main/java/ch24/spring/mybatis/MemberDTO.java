package ch24.spring.mybatis;

import org.springframework.stereotype.Service;
@Service("mybatisdto")
public class MemberDTO {
	String id, password, name, phone, email, address;

	public MemberDTO(){super();}
	
	// 다른 패키지에서 사용하기 위해서 public 붙인다.
	public MemberDTO(String id, String password){
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
