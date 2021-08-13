package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 	   이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 설정해서 데이터를 초기화처리 한다.
 	   
 	   이 Student객체는 List에 저장하여 관리한다.
 	   
 	   List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 	   총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를 작성하여 정렬한 결과를 출력하시오.
 
 	   (등수는 List에 전체 데이터가 추가된 후에 구한다.)
 */

public class StudentTest {
	// 등수를 구하는 메서드
	public void setRanking(ArrayList<Student> stuList) {
		for (Student stu1 : stuList) {	// 기준이 되는 데이터 개수만큼 반복
			int rank = 1;	// 등수가 저장될 변수 (처음에는 1등으로 셋팅한다.)
			for (Student stu2 : stuList) {	// 비교 대상을 나타내는 반복문
				// 기준보다 큰 값을 만나면 등수를 증가시킨다.
				if (stu1.getTotalScore() < stu2.getTotalScore()) {
					rank++;
				}
			}
			
			// 구해진 등수를 Student객체의 rank변수에 저장한다.
			stu1.setRank(rank);
		}
	}
	
	
	public static void main(String[] args) {
		StudentTest stuTest = new StudentTest();
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1, "홍길동", 74, 89, 92));
		list.add(new Student(7, "강감찬", 67, 89, 97));
		list.add(new Student(2, "이순신", 74, 96, 92));
		list.add(new Student(5, "성춘향", 74, 96, 92));
		list.add(new Student(4, "일지매", 74, 89, 23));
		list.add(new Student(3, "변학도", 74, 85, 92));
		list.add(new Student(6, "김철수", 34, 89, 92));
		
		// 등수를 구하는 메서드를 호출하여 등수를 구한다.
		stuTest.setRanking(list);
		
// 		< 등수 구하는 또 다른 방법 >
//		for (int i = 0; i < args.length; i++) {
//			for (int j = 0; j < args.length; j++) {
//				if (list.get(i).getTotalScore() < list.get(j).getTotalScore()) {
//					list.get(i).setRank(list.get(i).getRank() + 1);
//				}
//			}
//		}
		
		System.out.println("< 변경 전 >");
		
		for (Student stu : list) {
			System.out.println(stu);
		}
		
		System.out.println("\n< 학번의 오름차순 정렬 후 >");
		
		Collections.sort(list);

		for (Student stu : list) {
			System.out.println(stu);
		}
		
		System.out.println("\n< 총점의 역순으로 정렬 후 >");
		
		// 총점의 역순으로 정렬하기 (외부 정렬 기준 사용하기)
		Collections.sort(list, new SortTotal());
		
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
}
	
class Student implements Comparable<Student>{
	private int studentId;
	private String name;
	private int korean;
	private int math;
	private int english;
	private int totalScore; 
	private int rank;
	
	public Student(int studentId, String name, int korean, int math, int english) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.totalScore = korean + math + english; 
	}

	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKorean() {
		return korean;
	}


	public void setKorean(int korean) {
		this.korean = korean;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getEnglish() {
		return english;
	}


	public void setEnglish(int english) {
		this.english = english;
	}


	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", korean=" + korean + ", math=" + math
				+ ", english=" + english + ", totalScore=" + totalScore + ", rank=" + rank + "]";
	}
	// 학번의 오름차순으로 정렬할 수 있는 < 내부 정렬 기준 >
	@Override
	public int compareTo(Student stu) {
		return Integer.compare(this.getStudentId(), stu.getStudentId());
	}
	
}

// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 < 외부 정렬 기준 클래스 >
class SortTotal implements Comparator<Student> {
	
	public int compare(Student stu1, Student stu2) {
		if (stu1.getTotalScore() == stu2.getTotalScore()) {
			return stu1.getName().compareTo(stu2.getName());
		}
		return Integer.compare(stu1.getTotalScore(), stu2.getTotalScore()) * -1;
	}
}
