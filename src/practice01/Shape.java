package practice01.p08;

public abstract class Shape implements Comparable<Shape> {
	public Shape() {
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	/*
	 * Comparable : 비교해서 정렬할 때 필요한 메소드 
	 * 
	 * return이 
	 * 0(같을 때)이면 정렬 메소드에서 순서를 바꾸지 않는다.
	 * 1이면 배열 데이터의 순서를 바꾼다.
	 * -1이면 배열 데이터의 순서를 바꾸지 않는다.
	 * 현재 도형의 넓이(area())와 매개변수로 넘어온 도형의 넓이(o.area())를 비교해서
	 * 현재 도형의 넓이가 크면 1을 리턴
	 * 같으면 0을 리턴
	 * 현재 도형의 넓이가 작으면 -1을 리턴
	 */
	
	@Override
	public int compareTo(Shape o) {
		if (area() > o.area()) {
			return 1;
		} else if (area() < o.area()) {
			return -1;
		} else {
			return 0;
		}	
	}
	
	@Override
	public String toString() {
		return String.format("도형의 종류: %-9s 둘레: %-5.2fcm, 넓이: %.2fcm²",
					 		 getClass().getSimpleName(), perimeter(), area());
	}
}
