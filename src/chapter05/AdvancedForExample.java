package chapter05;

public class AdvancedForExample {
	public static void main(String[] args) {
		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0;
		
		// 원시
//		for (int i = 0; i < scores.length; i++) {
//			sum += scores[i];
//		}
		
		//classic
		for (int score : scores) {
			sum += score; 
		} //배열에 있는 내용을 인덱스 없이 순차적으로 값을 읽을 때 사용
		
		// 현재
		
		System.out.println("점수 총합 = " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균 = " + avg);
	}	
}
