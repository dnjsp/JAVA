package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];  // 입력용 스트림에 사용할 배열
		
		// 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			// 읽어올 데이터가 있는지 확인
			while(input.available() > 0) {
				/*
			    input.read(temp);
				output.write(temp);
				 */

				int len = input.read(temp);  // 실제 읽어온 데이터 수를 반환한다.
				
				// temp배열의 내용 중 0번째부터 len개수만큼 출력한다.
				output.write(temp, 0, len);
				
				System.out.println("반복문 안에서 temp : " + Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			System.out.println();
			System.out.println(" inSrc = " + Arrays.toString(inSrc));
			System.out.println(" outSrc = " + Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
