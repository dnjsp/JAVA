package chapter10;

public class ThrowExample {
	public static void main(String[] args) throws Exception {
//		findClass();
		throw new Exception(); // throw : 개발자가 직접 에러를 발생시키는 것
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
