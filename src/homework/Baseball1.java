package z_homework;

import java.util.Scanner;

public class Baseball1 {

	public static void main(String[] args) {
		
		System.out.println("중복되지 않는 세 자리 숫자(정답)를 입력하고,");
		System.out.println("세 자리 숫자를 최대 3번 입력받아 스트라이크, 볼, 아웃을 어쩌구 합니다.");
		System.out.println("\n 스트라이크 : 자리와 숫자가 일치하는 개수");
		System.out.println(" 볼 : 자리는 다르지만 숫자가 일치하는 개수");
		System.out.println(" 아웃 : 틀린 횟수");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n정답을 입력해 주세요! >> ");
		
		int target = scanner.nextInt(); // 567
		int t100 = (int) (target / 100); // 5.67 => int -> 5
		int t10 = (int) ((target % 100) / 10); // 567 % 100 => 67 / 10 => 6
		int t1 = (int) (target % 10); // 567 % 10 => 7
		int r100 = 0, r10 = 0, r1 = 0;
		
		boolean flag = false;
		
		int res = 0, s = 0, b = 0, o = 0;
		
		System.out.print(( o + 1 ) + "회 입니다. 예상숫자를 입력해주세요! >> ");
		res = scanner.nextInt();
		
		if(res < 100 || res > 999) {
			System.out.println("잘못 입력하셨습니다. 아웃 횟수가 추가됩니다.");
			o++;
		} else {
			r100 = (int) (res / 100);
			r10 = (int) ((res % 100) / 10);
			r1 = (int) (res % 10);
			if(r100 == t100) {
				s++;
			} else if(r100 == t10) {
				b++;
			} else if(r100 == t1) {
				b++;
			}
			if(r10 == t10) {
				s++;
			} else if(r10 == t100) {
				b++;
			} else if(r10 == t1) {
				b++;
			}
			if(r1 == t1) {
				s++;
			} else if(r1 == t100) {
				b++;
			} else if(r1 == t10) {
				b++;
			}
			if(s == 3) {
				flag = true;
			} else {
				o++;
			}
		}
		if(!flag) {
			System.out.println("틀렸습니다. 스코어는 " + s + "스트라이크, " + b + "볼, "
								+ o + "아웃입니다.");
			s = 0;
			b = 0;
			System.out.print(( o + 1 ) + "회 입니다. 예상숫자를 입력해주세요! >> ");
			res = scanner.nextInt();
			if(res < 100 || res > 999) {
				System.out.println("잘못 입력하셨습니다. 아웃 횟수가 추가됩니다.");
				o++;
			} else {
				r100 = (int) (res / 100);
				r10 = (int) ((res % 100) / 10);
				r1 = (int) (res % 10);
				if(r100 == t100) {
					s++;
				} else if(r100 == t10) {
					b++;
				} else if(r100 == t1) {
					b++;
				}
				if(r10 == t10) {
					s++;
				} else if(r10 == t100) {
					b++;
				} else if(r10 == t1) {
					b++;
				}
				if(r1 == t1) {
					s++;
				} else if(r1 == t100) {
					b++;
				} else if(r1 == t10) {
					b++;
				}
				if(s == 3) {
					flag = true;
				} else {
					o++;
				}
			}
			if(!flag) {
				System.out.println("틀렸습니다. 스코어는 " + s + "스트라이크, " + b + "볼, "
									+ o + "아웃입니다.");
				s = 0;
				b = 0;
			}
			System.out.print(( o + 1 ) + "회 입니다. 예상숫자를 입력해주세요! >> ");
			res = scanner.nextInt();
			if(res < 100 || res > 999) {
				System.out.println("잘못 입력하셨습니다. 아웃 횟수가 추가됩니다.");
				o++;
			} else {
				r100 = (int) (res / 100);
				r10 = (int) ((res % 100) / 10);
				r1 = (int) (res % 10);
				if(r100 == t100) {
					s++;
				} else if(r100 == t10) {
					b++;
				} else if(r100 == t1) {
					b++;
				}
				if(r10 == t10) {
					s++;
				} else if(r10 == t100) {
					b++;
				} else if(r10 == t1) {
					b++;
				}
				if(r1 == t1) {
					s++;
				} else if(r1 == t100) {
					b++;
				} else if(r1 == t10) {
					b++;
				}
				if(s == 3) {
					flag = true;
				} else {
					o++;
				}
			}
			if(!flag) {
				System.out.println("틀렸습니다. 스코어는 " + s + "스트라이크, " + b + "볼, "
									+ o + "아웃입니다.");
				s = 0;
				b = 0;
			}
		} else {
			System.out.println("축하합니다. 정답입니다!");
		}
		System.out.println();
		
		scanner.close();
	}
}