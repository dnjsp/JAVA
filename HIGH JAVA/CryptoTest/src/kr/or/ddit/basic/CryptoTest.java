package kr.or.ddit.basic;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {
	public static void main(String[] args) {
		try {
			String plainText = "Hello, World!! 안녕하세요 12345&*()";
			String key = "a1b2c3d4e5f6g7h8"; // 암호화 키 값 설정(16자리 이상)
			
			System.out.println("원본 문자열 : " + plainText);
			System.out.println();
			
			String hashStr = CryptoUtil.sha512(plainText);
			System.out.println("단방향 : " + hashStr);
			System.out.println("단방향 : " + hashStr.length());
			System.out.println();
			
			// 암호화하기
			String enStr = CryptoUtil.encryptAES256(plainText, key);
			System.out.println("암호화 : " + enStr);
			
			// 복호화하기
			System.out.println("복호화 : " + CryptoUtil.decryptAES256(enStr, key));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
