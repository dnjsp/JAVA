package practice01.p06;

public class NewCar {
	private double speed;
	private String color;
	private static final double MAX_SPEED = 200.0 / 1.6; // mile로 변경
	
	
	// 문제가 거리 단위를 km -> mile로 변경하는 거라서 method의 단위도 다 mile로 변경해줌 
	
	public NewCar() {
	}
	
	public NewCar(String color) {
		this.color = color;
	}

	public double getSpeed() {
		return mileToKillo(speed);
	}

	public void setSpeed(double speed) {
		this.speed = killoToMile(speed);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean speedUp(double speed) {
		if (this.speed + speed > 0 && this.speed + speed < mileToKillo(MAX_SPEED)) {
			this.speed += killoToMile(speed);
			return true;			
		} 
		return false;
	}
	
	public static double getMaxSpeed() {
		return mileToKillo(MAX_SPEED);
	}
	
	private static double killoToMile(double distance) {
		return distance * 0.625; 
			// distance / 1.6
	}
	
	private static double mileToKillo(double distance) {
		return distance * 1.6;
	}
	
	public String toString() {
		return "";
	}
}
