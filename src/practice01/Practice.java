package practice01;

public class Practice {
	public double radius, x, y;
	
	public Practice() {
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	
}
