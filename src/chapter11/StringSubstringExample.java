package chapter11;

public class StringSubstringExample {
	public static void main(String[] args) {
//		String ssn = "880815-1234567";
		String url = "https://www.naver.com";
		
		System.out.println(url.contains("naver"));
		System.out.println(url.matches("https://www.naver.com"));
	
	}
}
