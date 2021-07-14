package chapter06.exercise;

public class Calculator3 {
	static double pi = 3.141592;
	String calName = "계산기";
	
	String getCalName() {
		return calName;
	}
	static int plus(int x, int y) {
		Calculator3 calculator3 = new Calculator3();
		calculator3.getCalName();		
		return x + y;
	} // static에서는 class 안에 있는 calName을 사용할 수 없음
	  // 클래스를 새로 생성해서 사용해야 됨

	static int minus(int x, int y) {
		return x - y;
	}
}
