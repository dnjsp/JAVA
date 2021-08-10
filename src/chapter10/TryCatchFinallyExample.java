package chapter10;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
		// Class.forName("java.lang.String"); 입력 후 Ctrl + 1 => try ~. 선택
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 이걸 주석처리하면 에러가 발생하지 않음
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
}
