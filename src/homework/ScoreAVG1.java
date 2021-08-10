package z_homework;
import java.util.Random;

public class ScoreAVG1 {
	public static void main(String[] args) {
		Random random = new Random();
		
		String[] subject = {"국어", "수학", "영어", "과학", "코딩"};
		String[] name = {"홍길동", "이순신", "김유신", "유관순", "사임당", "아이유"};
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
		
		int[][] result = new int[score.length+1][score[0].length+1];
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				result[i][j] = score[i][j];
				result[i][score[0].length] += (result[i][j] / score[i].length);
				result[score.length][j] += (result[i][j] / score.length);
				result[score.length][score[0].length] += ((result[i][j] / score.length) / score[i].length);
			}
		}
		
		for (int i = 0;  i< result.length; i++) {
			if (i != 6) {
			System.out.print(name[i] + "\t");
			} else {
				System.out.print("평균\t");
			}
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
			System.out.println("====================================================");
	}
}
