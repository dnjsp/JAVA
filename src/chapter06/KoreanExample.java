package chapter06;

public class KoreanExample {
	public static void main(String[] args) {
		
		Korean k1 = new Korean("박자바", "011225-1234567");
		Korean k2 = new Korean("김자바", "930525-0654321");
		
		System.out.println(k1.name);
		System.out.println(k2.ssn);
	}
}
