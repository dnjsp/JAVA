package practice02.p04;

public class ForForIf {
	public static void main(String[] args) {
		
		for (int num1 = 1; num1 <= 6; num1++) {
			for (int num2 = 1; num2 <= 6; num2++) {
				if (num1 + num2 == 6) {
			System.out.println("(" + num1 + "," + num2 + ")");
				}
			}
		}
	}
}
