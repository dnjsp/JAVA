package kr.or.ddit.basic; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashSet; 
import java.util.Random; 
import java.util.Scanner; 
/* 
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.  
 * 		 컴퓨터의 숫자는 난수를 이용하여 구한다. 
 * 		 (스트라이크는 S, 볼은 B로 나타낸다.) 
 *  
 *    예시) 컴퓨터의 난수 -> 9 5 7 ===> 난수 생성시 Set 사용 (다시 list에 넣어줌 => S, B 구하기 용이함) 
 *    실행 예시) 숫자 입력 >> 3 5 6 (입력받은 값) 
 *    출력) 3 5 6 : 1S 0B 
 *    		숫자 입력 >> 7 8 9 (입력받은 값) 
 *    출력) 7 8 9 : 0S 2B 
 *    		숫자 입력 >> .. 
 *    		: 
 *    축하합니다. 당신은 n번째 만에 맞혔습니다. 
 */ 
public class BaseBallTest01 { 
	public static void main(String[] args) { 
		Random random = new Random(); 
		Scanner scanner = new Scanner(System.in); 
		HashSet<Integer> set = new HashSet<>(); 
		while (set.size() < 3) { 
			set.add(random.nextInt(9) + 1); 
		} 

//		System.out.println(set); 
//		System.out.println("set 데이터를 list로 변환"); 

		ArrayList<Integer> list = new ArrayList<>(set); 
		Collections.shuffle(list); 

//		for (int i = 0; i < list.size(); i++) { 
//			System.out.println(list.get(i)); 
//		} 

		ArrayList<Integer> input = new ArrayList<>(); 

//		System.out.println("list " + list); 
		
		int strike = 0; 
		int ball = 0; 
		int count = 0; 
		
		while (true) { 
			input.clear(); 
			strike = 0; 
			ball = 0; 
			
			System.out.println(); 
			System.out.print("숫자 입력 >> "); 
			
			input.add(scanner.nextInt()); 
			input.add(scanner.nextInt()); 
			input.add(scanner.nextInt()); 
			
			System.out.println(); 
			System.out.println("────────────────────"); 
			System.out.println("input " + input); 
			System.out.println("────────────────────"); 
			
			for (int i = 0; i < list.size(); i++) { 
				if (list.get(i) == input.get(i)) { 
					strike++; 
				} 
				
				for (int j = 0; j < list.size(); j++) { 
					if (list.get(i) != input.get(i) && list.get(i) == input.get(j)) { 
						ball++; 
					} 
				} 
			} 
			
			count++; 
			
			if (strike == 3) { 
				break; 
			} 
			
			System.out.println(strike + "S " + ball + "B"); 
		} 
		
		System.out.println(); 
		System.out.println("축하합니다. 당신은 " + count + "번 만에 맞혔습니다."); 
		
		scanner.close(); 
	} 
}