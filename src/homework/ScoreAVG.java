package z_homework;

import java.util.Random;

public class ScoreAVG {
	public static void main(String[] args) {
		Random random = new Random();
		
		String[] subject = {"국어", "수학", "영어", "과학", "코딩"};
		String[] name = {"홍길동", "이순신", "김유신", "유관순", "사임당", "아이유"};
		double[] avg = new double[subject.length];
		double[] tot = new double[name.length];
		int[][] score = new int[name.length][subject.length];
		
		
		System.out.println("=================== 원점수 ===================");
		System.out.print("학생명");
		for (int i = 0; i < subject.length; i++) {
			System.out.print("\t" + subject[i] );
		}
		System.out.println(); 
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = random.nextInt(31) + 70;
				tot[i] += score[i][j];
				avg[j] += score[i][j];
				System.out.print(score[i][j] + "\t");
			}
			
			System.out.println();
		}
		
		System.out.println("==============================================");
		System.out.println();
		System.out.println();
		
		System.out.println("===================== 평균점수 =====================");
		System.out.print("학생명");
		for (int i = 0; i < subject.length; i++) {
			System.out.print("\t" + subject[i] );
		}
		System.out.println("\t평균");
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.printf("%.1f\t", tot[i]/subject.length);
			System.out.println();
		
			}
			System.out.print("평균\t");
			double tot_avg = 0.0;
			for (int i = 0; i < avg.length; i++) {
				System.out.printf("%.1f\t", avg[i]/name.length);
				tot_avg += avg[i]/name.length;
			}
			System.out.printf("%.1f\t", tot_avg/subject.length);
			System.out.println();
			System.out.println("====================================================");
		}
	}
