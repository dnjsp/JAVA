package practice02.p04;

public class Exercise041 {

	public static void main(String[] args) {
		int sum = 0;
		int s = 1;
		int num = 0;
		
		for (int i = 1; sum < 100; i++, s = -s) {
			num = s * i;
			sum += num;
			
			if (sum >= 100) {
				break;
			}
		}
		System.out.println(num);
	}

}
