package chapter06;

public class FourthCarExample {
	public static void main(String[] args) {
		FourthCar car = new FourthCar();
		
		car.setSpeed(-50);
		
		System.out.println("현재 속도: " + car.getSpeed());
		
		car.setSpeed(50);
		
		System.out.println("현재 속도: " + car.getSpeed());
		
		if (!car.isStop()) {
			car.setStop(true);
		}
		System.out.println("현재 속도: " + car.getSpeed());		
	}
}
