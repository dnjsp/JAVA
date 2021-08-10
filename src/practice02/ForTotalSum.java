package practice02.p04;

public class ForTotalSum {
	public static void main(String[] args) {
		int sum = 0;
		int totalSum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
			totalSum += sum;
						
		}
		System.out.println(totalSum);
	}
}
