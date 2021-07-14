package chapter07;

public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();
	// 메소드에다가 abstract를 붙이면 추상메소드가 됨
	// 메소드에 abstract가 있으면 클래스에도 있어야 됨
	// Ctrl + 1 눌러서 Make~ 선택
	
}
