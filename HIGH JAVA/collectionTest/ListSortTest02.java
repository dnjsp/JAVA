package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(6, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(4, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬 전...");
		
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println();
		
		Collections.sort(memList);
		
		System.out.println("정렬 후...");
		
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println();
		
		
		//Member의 name값의 오름차순 정렬을 하는 외부 정렬 기준을 이용하여 정렬하기
		
		Collections.sort(memList, new SortName());
		
		System.out.println("회원이름의 오름차순 정렬 후 ");
		
		for (Member mem : memList) {
			System.out.println(mem);
		}
		
	}
}

// Member의 num값의 내림차순으로 정렬할 수 있는 내부 정렬 기준 설정하기

class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	// 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	// num값의 내림차순

	@Override
	public int compareTo(Member mem) {
//		if(this.getNum() > mem.getNum()) {
//			return -1;
//		} else if(this.getNum() < mem.getNum()){
//			return 1;	// 양수를 반환하면 두 값의 순서가 바뀐다.
//		} else {
//			return 0;
//		}
		
		// Wrapper클래스를 이용하는 방법1
		//return new Integer(this.getNum()).compareTo(mem.getNum()) * -1;
		
		// Wrapper클래스를 이용하는 방법2
		return Integer.compare(this.getNum(), mem.getNum()) * -1;
	}
}


// 외부 정렬 기준 ==> 회원 이름의 오름차순 정렬이 될 수 있는 외부 정렬 기준 만들기

class SortName implements Comparator<Member> {
	
	@Override
	public int compare(Member mem1, Member mem2) {
		return mem1.getName().compareTo(mem2.getName());
	}
}


