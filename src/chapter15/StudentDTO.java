package chapter15;
/*
 * DTO(Data Transfer Object) 이건 옛날 코드여서
 * ***** VO(Value Object) ***** 이 코드를 사용하는 게 좋음
 * Model => Data
 * Item => StudentItem
 * Bean(콩) : 자바가 커피라는 이름이라서 객체를 가리킬 때 사용 StudentBean
 */
public class StudentDTO {
	private String id;
	private String name;
	private String email;
	private String mobileNumber;

	public StudentDTO(String id, String email, String mobileNumber) {
		this.id = id;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	public StudentDTO(String id, String name, String email, String mobileNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}

}
