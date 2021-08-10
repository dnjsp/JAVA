package chapter11;

import java.util.Arrays;

public class ByteToStringExample {
	public static void main(String[] args) {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		
		String hong = "홍길동";
		byte[] byt = hong.getBytes();
		System.out.println(Arrays.toString(byt));
		String str3 = new String(byt);
		System.out.println(str3);
	}
}
