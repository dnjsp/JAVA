package chapter08;

public class MyCalssExample {
	public static void main(String[] args) {
		System.out.println("1)-----------------------");
		MyClass class1 = new MyClass(); // 오른쪽에 있는 게 먼저 실행되고 MyClass가 호출됨
		class1.rc.turnOn();
		class1.rc.setVolume(5);

		System.out.println("2)-----------------------");
		MyClass class2 = new MyClass(new Audio());
		
		System.out.println("3)-----------------------");
		MyClass class3 = new MyClass();
		class3.methodA();

		System.out.println("4)-----------------------");
		MyClass class4 = new MyClass();
		class4.methodB(new Television());
	}
}
