package chapter05.exercise;

import java.util.Scanner;

public class Exercise6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 실행 진행 여부
		boolean run = true;
		// 학생 수
		int studentNum = 0;
		// 학생의 점수를 저장할 배열
		int[] scores = null;
		
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if (selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				// scores.length == sutdentNum
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]> " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0;
				double avg = 0;
				
				for (int i = 0; i < scores.length; i++) {
					// 최댓값 구하기
					if (max < scores[i]) {
						max = scores[i];
					}
					// 총 합계 구하기
					sum += scores[i];
				}
				// 평균
				avg = (double) sum / studentNum; // scores.length로 나눠줘도 됨
				
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + avg);
				
			} else if (selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
		scanner.close();
	}
}
