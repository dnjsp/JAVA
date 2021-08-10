package chapter09.exercise;

public class Anonymous2 {
	Vehicle field = new Vehicle() {

		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};

	public void method1() {

		Vehicle localVar = new Vehicle() {

			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};

		localVar.run();
	}

	public void method2(Vehicle v) {

		v.run();
	};
}
