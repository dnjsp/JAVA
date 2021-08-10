package practice02.p04;

public class Exercise042 {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		
		while (sum < 100) {
			i++;
			if (i % 2 == 0) {
				sum -= i;
			} else{
				sum += i;
			} 
		} 
		System.out.println(i);
	}
}
