package chapter06;

public class FirstCarExample {
	public static void main(String[] args) {
		// 객체 생성
		FirstCar Car = new FirstCar();
		
		// 필드값 읽기
		System.out.println("제작회사: " + Car.company);
		System.out.println("모델명: " + Car.model);
		System.out.println("색깔: " + Car.color);
		System.out.println("최고속도: " + Car.maxSpeed);
		System.out.println("현재속도: " + Car.speed);
		
		// 필드값 변경
		Car.speed = 60;
		System.out.println("수정된 속도: " + Car.speed);
	}
}
