package practice01.p06;

public class Time {
	private int hour, minute, second;
	
	public Time() {
	}
	
	public Time(int hour, int minute, int second) {
		if (hour > 0 && hour < 24) {
			this.hour = hour;
		} 
		if (minute > 0 && minute < 60) {
			this.minute = minute;
		}
		if (second > 0 && second < 60) {
			this.second = second;
		}
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
}
