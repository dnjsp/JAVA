package chapter11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
	public static void main(String[] args) {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yy년 M월 d일")));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern
													 ("yyyy년 MM년 dd일 E요일 hh:mm:ss.ms")));
	}
}
