package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileIOTest04 {
	public static void main(String[] args) {
		try {
			// 사용자가 입력한 내용을 그대로 파일에 저장하기 ==> 문자 기반 스트림 이용
			
			// System.in, System.out ==> 콘솔(표준입출력장치)
			// System.in(입력용 => 키보드), System.out(출력용 => 화면)
			
			// 바이트 기반의 스트림을 문자기반의 스트림으로 변환해주는 스트림
			//  ==> InputStreamReader (입력용)
			//  ==> OutputStreamReader (출력용)
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("아무 내용이나 입력하세요. (입력의 끝은 Ctrl + Z 입니다.)");
			
			int c;
			
			while ((c = isr.read()) != -1) {
				fw.write(c);  // 콘솔로 입력받은 데이터를 파일에 출력한다.
			}
			
			isr.close();
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}