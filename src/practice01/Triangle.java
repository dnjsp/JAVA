package practice01.p08;

public class Triangle extends Shape {
	private double side;
	
	public Triangle(double side) {
		this.side = side;
	}
	
	public double area() {
		return Math.sqrt(3) / 4.0 * (side * side);
	}
	
	public double perimeter() {
		return side * 3.0;
	}
	
//	public String toString() {
//		return "도형의 종류: 삼각형, 둘레:" + perimeter() + "cm, 넓이:" + area() + "cm²"; 
//	}
}
