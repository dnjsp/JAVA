package z_homework;

public class CalculatorExample {
	public static void main(String[] args) {	
		Calculator myCal = new Calculator();
		
		double result1 = myCal.add(123456, 654321);
		double result2 = myCal.multipl(result1, 123456);
		double result3 = myCal.divide(result2, 123456);
		double result4 = myCal.minus(result3, 654321);
		double result5 = myCal.remainder(result4, 123456);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
	}
}
