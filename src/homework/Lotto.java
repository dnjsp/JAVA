package z_homework;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		System.out.println("로또를 1~5개 자동번호 구매하고 당회차 번호를 맞춘 상금을 출력해 봅시다.");

		Scanner sc = new Scanner(System.in);

		int count = 1;
		mainWhile: while (true) {
			System.out.println("==================== 로또 판매점 ====================");
			System.out.println("1.로또구입\t2.소지금확인\t3.종료");
			System.out.println("=====================================================");
			System.out.print("원하는 메뉴 선택 >> ");
			int[][] myLotto = new int[5][6];
			int[] matchLotto = new int[6];
			int bonusNumber = 0;
			boolean bonusMatch = false;
			switch (sc.nextInt()) {
			case 1:
				System.out.println("---------- 로또 구입 ----------");
				System.out.print("몇 장을 구입하시겠습니까? >> ");
				int c;
				do {
					c = sc.nextInt();
				} while (c < 0 || c > 5);

				for (int i = 0; i < c; i++) {
					myLotto[i] = LottoShop.getLotto();
				}

				System.out.println("---------- 내 번호 ----------");
				for (int i = 0; i < c; i++) {
					System.out.println(Arrays.toString(myLotto[i]));
				}

				System.out.println("로또 추첨 중 ...");
				matchLotto = LottoShop.getLotto();
				bonusNumber = LottoShop.getBonusNumber(matchLotto);

				System.out.println("---------- 당첨 확인 ----------");
				System.out.println(count + "회차 당첨번호 : " + Arrays.toString(matchLotto) + " (보너스:" + bonusNumber + ")");
				for (int i = 0; i < c; i++) {
					// System.out.println(Arrays.toString(myLotto[i]));
					int matchCount = 0;
					System.out.print("[");
					for (int j = 0; j < myLotto[i].length; j++) {
						boolean check = false;
						if (j > 0)
							System.out.print(", ");
						for (int k = 0; k < matchLotto.length; k++) {
							if (myLotto[i][j] == matchLotto[k]) {
								check = true;
							}
						}
						if (check) {
							System.out.print("(" + myLotto[i][j] + ")");
							matchCount++;
						} else
							System.out.print(myLotto[i][j]);
					}
					if (matchCount == 5) {
						for (int j = 0; j < matchLotto.length; j++) {
							if (myLotto[i][j] == bonusNumber)
								bonusMatch = true;
						}
					}
					System.out.println("] => " + rewordCheck(matchCount, bonusMatch));
				}

				count++;
				break;
			case 3:
				break mainWhile;
			}
			System.out.println();
			sc.close();
		}
	}

	private static String rewordCheck(int matchCount, boolean bonusMatch) {
		String result = "";
		switch (matchCount) {
		case 0:
		case 1:
		case 2:
			result = "낙첨";
			break;
		case 3:
			result = "5등";
			break;
		case 4:
			result = "4등";
			break;
		case 5:
			if (bonusMatch)
				result = "2등";
			else
				result = "3등";
			break;
		case 6:
			result = "1등!!!";
			break;
		}
		return result;
	}

}
