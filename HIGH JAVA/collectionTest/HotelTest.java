package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HotelTest {
	Scanner scanner = new Scanner(System.in);
	HashMap<Integer, Room> map = new HashMap<Integer, Room>();
	
	public static void main(String[] args) {
		new HotelTest().start();
	}
	
	public void start() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************\n\n");
		
		roomInfo();
		
		while (true) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
			System.out.println("-----------------------------------------------------------");
			/*
			 		 _	 _		   _
					| | | |       | |                    
					| |_| |  __ _ | |__    __ _          
					|  _  | / _` || '_ \  / _` |         
					| | | || (_| || | | || (_| | _  _  _ 
					\_| |_/ \__,_||_| |_| \__,_|(_)(_)(_)
			 */
			System.out.print("선택 >> ");
			int input = scanner.nextInt();
			System.out.println();
			switch (input) {
				case 1: checkIn(); break;
				case 2: checkOut(); break;
				case 3: roomInfoList(); break;
				case 4: exit();
				default:
					System.out.println("잘못 입력하였습니다.");
					System.out.println("다시 입력하세요.\n");
					break;
			}
		}
	}	
	
	public void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int roomNumber = scanner.nextInt();
		if (!map.containsKey(roomNumber)) {
			System.out.println(roomNumber + "호 객실은 존재하지 않습니다.\n");
			return;
		}
		if (!map.get(roomNumber).getCustomerName().equals("-")) {
			System.out.println(roomNumber + "호 객실은 이미 손님이 있습니다.\n");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String customerName = scanner.next();
		String roomType = map.get(roomNumber).getRoomType();
		map.put(roomNumber, new Room(roomNumber, roomType, customerName));
		System.out.println("체크인이 완료되었습니다.\n");
	}
	
	public void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int roomNumber = scanner.nextInt();
		if (!map.containsKey(roomNumber)) {
			System.out.println(roomNumber + "호 객실은 존재하지 않습니다.\n");
			return;
		}
		if (map.get(roomNumber).getCustomerName().equals("-")) {
			System.out.println(roomNumber + "호 객실에는 체크인 한 사람이 없습니다.\n");
			return;
		}
		String roomType = map.get(roomNumber).getRoomType();
		String customerName = map.get(roomNumber).getCustomerName();
		System.out.println(roomNumber + "호 객실의 " + customerName + "님 체크아웃을 완료하였습니다.\n");
		map.put(roomNumber, new Room(roomNumber, roomType, "-"));
	}
	
	public void roomInfoList() {
		ArrayList<Integer> keyList = new ArrayList<Integer>(map.keySet());
		
		System.out.println("----------------------------------------------");
		System.out.println("	       현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t\t방 종류\t\t투숙객 이름");
		System.out.println("----------------------------------------------");
		Collections.sort(keyList);
		
		for (Integer integer : keyList) {
			System.out.println(map.get(integer));
		}
		
		System.out.println("----------------------------------------------");
		
	}
	
	public void exit() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 닫았습니다.");
		System.out.println("*********************************************");
		System.exit(0);
	}	
	
	public void roomInfo() {
		for (int i = 1; i < 10; i++) {
			map.put(200 + i, new Room(200 + i, "싱글룸", "-"));
			map.put(300 + i, new Room(300 + i, "더블룸", "-"));
			map.put(400 + i, new Room(400 + i, "스위트룸", "-"));
		}
	}
}

class Room {
	private int roomNumber;
	private String roomType;
	private String customerName;
	
	public Room(int roomNumber, String roomType, String customerName) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.customerName = customerName;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
//		return roomNumber + "\t\t " + roomType + "\t\t" + customerName;
		return String.format("%d\t%10s\t%12s", roomNumber, roomType, customerName);
	}
}

