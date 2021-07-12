package chapter02.exercise;

public class Exercise1 {

	public static void main(String[] args) {

		String name = "김자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n" );
		
		/* 
		 * 숫자 : digit -> %d
		 * 문자열 : String -> %s
		 * 실수형 : float -> %f
		 */
		System.out.printf("전화: %s-%s-%s", tel1, tel2, tel3);
		String str = String.format("\n전화: %s-%s-%s", tel1, tel2, tel3);
		System.out.println(str);
	}

}
