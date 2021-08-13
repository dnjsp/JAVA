package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelTest1 {
	Map<Integer, Room1> hotelMap;
	Scanner scan;
	
	public HotelTest1(){
		hotelMap = new HashMap<Integer, Room1>();
		scan = new Scanner(System.in);
		
		for (int i = 2; i <= 4; i++) {
			String roomType = null;
			switch (i) {
			case 2: roomType = "싱글룸"; break;
			case 3: roomType = "더블룸"; break;
			case 4: roomType = "스위트룸"; break;
			}
			
			for (int j = 1; j <= 9; j++) {
				int roomNumber = i * 100 + j;
				hotelMap.put(roomNumber, new Room1(roomNumber, roomType));
			}
		}
	}
	
	public static void main(String[] args) {
		new HotelTest1().hotelStart();
	}
	
	// 시작 메서드 
	public void hotelStart() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************\n\n");
		
		while (true) {
			int choice = displayMenu();
			switch (choice) {
				case 1: checkIn(); break;	// 체크인
				case 2: checkOut(); break;	// 체크아웃
				case 3: dispalyRoomList(); break;	// 객실상태
				case 4: 
					System.out.println("*********************************************");
					System.out.println("       호텔문을 닫았습니다.");
					System.out.println("*********************************************");
					System.exit(0);
					break;	// 종료
				default:
					System.out.println("잘못 입력하였습니다.");
					System.out.println("다시 입력하세요.\n");
					break;
			}
		}
	}
	
	// 객실 상태를 출력하는 메서드
	private void dispalyRoomList() {
		
		// 방 번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값)만 List에 넣은 후 정렬하여 사용한다.
		ArrayList<Integer> roomNumList = new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(roomNumList);	// 방 번호의 오름차순 정렬
		
		System.out.println("----------------------------------------------");
		System.out.println("	       현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t\t방 종류\t\t투숙객 이름");
		System.out.println("----------------------------------------------");
		
		// List에서 방 번호를 하나씩 꺼내와 Map에서 해당 방번호에 대한 Room객체를 구해서 출력한다.
		for (int num : roomNumList) {
			Room1 r = hotelMap.get(num);
		
			// 투숙객 이름이 null이면 '-'로 변경해 준다.
			String name = r.getGuestName();
			if (name == null) name = "-";
			
			System.out.println(r.getRoomNumber() + "\t\t" + r.getRoomType() + "\t\t" + name);
		}
		
		System.out.println("----------------------------------------------");
	}
	
	// 체크아웃 메서드
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int num = scan.nextInt();
		
		// 객실의 존재여부 검사
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.\n");
			return;
		}
		
		// 해당 객실에 투숙객이 없는지 검사
		if (hotelMap.get(num).getGuestName() == null) {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.\n");
			return;
		}

		// 해당 객실의 현재 투숙객 이름을 구한다.
		String name = hotelMap.get(num).getGuestName();
		
		// 체크아웃 작업은 해당 객실의 투숙객 이름을 null로 변경하는 작업이다.
		hotelMap.get(num).setGuestName(null);
		
		System.out.println(num + "호 객실의 " + name + "님 체크아웃을 완료하였습니다.\n");
		
	}
	
	// 체크인 메서드
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int num = scan.nextInt();
		
		// 객실의 존재여부 검사
		if (!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.\n");
			return;
		}
		
		// 해당 객실에 다른 투숙객이 있는지 검사
		if (hotelMap.get(num).getGuestName() != null) {
			System.out.println(num + "호 객실은 이미 손님이 있습니다.\n");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = scan.next();
		
		// 입력받은 투숙객 이름을 해당 객실의 투숙객 명단에 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		System.out.println("체크인이 완료되었습니다.\n");
		
		
	}
	
	// 메뉴를 출력하고 작업번호를 입력받아서 반환하는 메서드
	private int displayMenu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택 >> ");
		int num = scan.nextInt();
		return num;
	}
}

class Room1 {
	private int roomNumber;	// 방 번호
	private String roomType;	// 방 종류
	private String guestName;	// 투숙객 이름
	
	public Room1(int roomNumber, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public String toString() {
		return String.format("%d\t%10s\t%12s", roomNumber, roomType, guestName);
	}	
}