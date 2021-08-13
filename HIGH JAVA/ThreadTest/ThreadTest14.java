package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Random;

/*
 	 10마리의 말들이 경주하는 프로그램을 작성하시오.
 		
 	 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
 	 이 클래스는 말 이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖는다.
 	 그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
 	 (Comparable인터페이스 구현)
 	 
 	 경기 구간은 1 ~ 50구간으로 되어 있다.
 	 
 	 경기 중간 중간에 각 말들의 위치를 나타낸다.
 	 
 	 예)
 	 01번 말 --->----------------------------------------------
 	 02번 말 ------->------------------------------------------
 	 ...
 	 10번 말 ---->---------------------------------------------
 	
 	 경기가 끝나면 등수 순으로 출력한다.
 	 
 */

public class ThreadTest14 {
	
	public static void main(String[] args) {
		Horse[] horses = new Horse[] {
			new Horse("01번 말"), new Horse("02번 말"),
			new Horse("03번 말"), new Horse("04번 말"),
			new Horse("05번 말"), new Horse("06번 말"),
			new Horse("07번 말"), new Horse("08번 말"),
			new Horse("09번 말"), new Horse("10번 말")
		};
		
		GameStateThread gst = new GameStateThread(horses);
		
		for (Horse h : horses) {
			h.start();			  // 말의 경주 시작
		}
		
		gst.start();	// 말들의 현재 위치를 출력하는 쓰레드 시작
		
		try {
			for (Horse h : horses) {
				h.join();
			}
			gst.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		// 등수의 오름차순으로 정렬하여 출력한다.
		Arrays.sort(horses);	// 배열 정렬하기
		
		System.out.println("경기 결과");
		for (Horse h : horses) {
			System.out.println(h);
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	public static int currentRank = 0;  // 각각의 말의 경기가 끝나면 1씩 증가한다.
	
	private String horseName;  // 말이름
	private int location;	   // 현재위치
	private int rank;		   // 등수
	
	// 생성자
	public Horse(String horesName) {
		this.horseName = horesName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "경주마 " + horseName + "은(는) " + rank + "등 입니다.";
	}

	// 등수의 오름차순
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(rank, horse.getRank());
	}
	
	// 쓰레드에서 달리기 기능을 구현한다.
	@Override
	public void run() {
		Random rnd = new Random();
		for (int i = 1; i <= 50; i++) {
			this.location = i;	// 말의 현재 위치를 저장한다.
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// 한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}	
}

/*
 	경기 중간 중간에 각 말들의 위치를 나타낸다.
 	 
 	 예)
 	 01번 말 --->----------------------------------------------
 	 02번 말 ------->------------------------------------------
 	 ...
 	 10번 말 ---->---------------------------------------------
 	
 	 경기가 끝나면 등수 순으로 출력한다.
 */

//경기 중 말의 위치를 표시하는 쓰레드
class GameStateThread extends Thread {
	private Horse[] horses;  // 경기에 참가한 말들을 저장할 배열

	// 생성자
	public GameStateThread(Horse[] horses) {
		this.horses = horses;
	}

	@Override
	public void run() {
		while (true) {
			// 모든 말들의 경기가 종료되었을 때 이 쓰레드도 종료되게 한다.
			if (Horse.currentRank == horses.length) {
				break;
			}
			
			for (int i = 0; i < 100; i++) {
				System.out.println();
			}
			
			for (int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for (int j = 1; j <= 50; j++) {
					if (j == horses[i].getLocation()) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();	// 줄바꿈
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
