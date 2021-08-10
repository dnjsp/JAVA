package practice01.p06;

public class Car {
	private double speed;
	private String color;
	private static final double MAX_SPEED = 200.0;
	// static final이 붙으면 초기값을 무조건 적어줘야함
	
	public Car() {
	}
	
	public Car(String color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean speedUp(double speed) {
		if (this.speed + speed > 0 && this.speed + speed < MAX_SPEED) {
			this.speed += speed;
			return true;			
		} // 목표값을 변경해주는 거라서 현재속도에 속도를 더해줘야됨
		return false;
	}
	public static double getMaxSpeed() {
		return MAX_SPEED;
	}
	public String toString() {
		return "";
	}
}
