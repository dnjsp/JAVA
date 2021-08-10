package practice02.p04;

public class ForStar1 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + i*j + "\t");
			}

		}
	}
}
