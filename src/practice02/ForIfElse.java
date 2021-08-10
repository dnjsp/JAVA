package practice02.p04;

public class ForIfElse {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		
		for (i = 1; sum < 100; ++i) {
			if (i % 2 == 0) {
				sum -= i;
 			} else {
				sum += i;
			} 
			if (sum >= 100) {
				break;
			}
		}
		System.out.println(i);
	}
}
