package chapter06;

public class ThirdCarExample {
	public static void main(String[] args) {
		ThirdCar car = new ThirdCar();
		
		car.setGas(5); 
		
		boolean gasState = car.isLeftGas();
		if (gasState) {
			System.out.println("출발합니다.");
			car.run();
		}
		
		if (car.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}
}
