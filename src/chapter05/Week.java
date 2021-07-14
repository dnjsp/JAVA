package chapter05;

public enum Week {
	// 상수 자체도 하나의 객체, 내부적으로 값을 부여할 수 있음	
	MONDAY("월", 1),
	TUESDAY("화", 2),
	WEDNESDAY("수" ,3),
	THURSDAY("목", 4),
	FRIDAY("금", 5),
	SATURDAY("토", 6),
	SUNDAY("일", 7);
	
	String korOfWeek;
	int day;
	
	Week(String korOfWeek, int day) { //에러난 부분에 마우스 올리고 Create ~ 클릭
		this.korOfWeek = korOfWeek;
		this.day = day;
	}
	// get + ctrl + space
	public String getKorOfWeek() {
		return korOfWeek;
	}
}
