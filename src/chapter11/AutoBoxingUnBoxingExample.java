package chapter11;

public class AutoBoxingUnBoxingExample {
	public static void main(String[] args) {

		Integer obj = 100; // 자동 박싱 (autoboxing)
		System.out.println("value: " + obj.intValue());
		
		int value = obj; // 자동 언박싱 (auto unboxing)
		System.out.println("value: " + value);
		
		int result = obj + 100; // 연산시 자동 언박싱 (auto unboxing)
		System.out.println("result: " + result);
		
	}
}
