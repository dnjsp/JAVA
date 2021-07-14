package chapter06;

public class SecondCar {
	// 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 생성자
	SecondCar() {
		this(null, null, 0);
	}
	
	SecondCar(String model) {
		this(model, null, 0);
		// 중복되는 코드에 초기값을 넣어서 마지막 SecondCar를 호출해 관리하도록 하는 것
	}
	
	SecondCar(String model, String color) {
		this(model, color, 0);
	}
	
	SecondCar(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
