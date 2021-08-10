package chapter09.exercise;

public class Anonymous {

	Worker field = new Worker() {

		public void start() {
			System.out.println("디자인을 합니다.");
		}
	};

	public void method1() {

		Worker localVar = new Worker() {

			public void start() {
				System.out.println("개발을 합니다.");
			}
		};

		localVar.start();
	}

	public void method2(Worker worker) {

		worker.start();
	};
}
