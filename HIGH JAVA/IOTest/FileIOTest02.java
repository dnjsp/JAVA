package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		// 바이트 기반의 스트림을 이용하여 파일에 출력하기
		try {
			// 파일 출력용 스트림 객체 생성
			FileOutputStream fos = new FileOutputStream("d:/d_other/out.txt");
			
			System.out.println("출력작업 시작...");
			
			for (char ch = 'A'; ch <= 'Z'; ch++) {
				fos.write(ch);  // ch변수의 데이터를 파일로 출력한다.
				if ((ch + 4) % 6 == 0) {
					fos.write('\n');
				}
			}
			
			// 위에서 저장한 파일을 읽어와 화면에 출력하시오.
			File file = new File("d:/d_other/out.txt");
            FileInputStream fis = new FileInputStream(file);
           
            int c; // 읽어온 데이터가 저장될 변수
           
            while ((c = fis.read()) != -1) {
               // 읽어온 데이터를 화면에 출력하기
               System.out.print((char) c);
            }
           
            System.out.println("출력작업 완료....");
            fos.close(); // 쓰기 작업 완료 후 스트림 닫기 
			fis.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
