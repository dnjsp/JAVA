package chapter09.exercise;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();

		anony.field.start();
		anony.method1();
		anony.method2(new Worker() {
		
			@Override
			public void start() {
				System.out.println("테스트를 합니다.");
			}
		}

		);

		Worker w = new Worker();
		w.start();
	}
}
