package chapter05;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EunmWeekExample {
	public static void main(String[] args) {
		// 예전에는 Calendar를 사용했으나, Calendar와 Date 객체는 보안상 사용을 안 하는 것이 좋음
		DayOfWeek week = LocalDate.now().getDayOfWeek(); //LocalDate.now(). - getDatyOfWeek 선택 - Ctrl +1
		Week today = null;
	
		switch (week) {
		case SUNDAY:
			today = Week.SUNDAY;
			break;
		case MONDAY:
			today = Week.MONDAY;
			break;
		case TUESDAY:
			today = Week.TUESDAY;
			break;
		case WEDNESDAY:
			today = Week.WEDNESDAY;
			break;
		case THURSDAY:
			today = Week.THURSDAY;
			break;
		case FRIDAY:
			today = Week.FRIDAY;
			break;
		case SATURDAY:
			today = Week.SATURDAY;
			break;

		default:
			break;
		}
		System.out.println("오늘 요일: " + today);
		System.out.println("오늘 요일: " + today.getKorOfWeek()); // 한글로 출력됨
		
		if (today == Week.SATURDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부합니다.");
		}
	}
}
