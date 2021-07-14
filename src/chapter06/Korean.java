package chapter06;

public class Korean {
	// 필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	// 생성자
	public Korean(String name, String ssn) {
		this.name = name;  // 메모리에 만들어져 있는 객체 자신을 this로 표시
		this.ssn = ssn;
	}
}
