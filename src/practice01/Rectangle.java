package practice01.p08;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		return width * height;
	}
	
	public double perimeter() {
		return 2 * (width + height);
	}
	
//	public String toString() {
//		return "도형의 종류: 사각형, 둘레:" + perimeter() + "cm, 넓이:" + area() + "cm²"; 
//	}
}
