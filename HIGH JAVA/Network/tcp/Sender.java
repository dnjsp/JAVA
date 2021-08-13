package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 통해서 메세지를 보내는 역할을 담당한다.
public class Sender extends Thread{
	@SuppressWarnings("unused")
	private Socket socket;
	private DataOutputStream dos;
	private String name;
	private Scanner scan;
	
	// 생성자
	public Sender(Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.println("이름 입력 >> ");
		name = scan.nextLine();
		
		try {
			// 출력용 스트림 객체 생성
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while (dos != null) {
			try {
				// 메세지를 입력 받아 '이름'뒤에 붙여서 전송한다.
				dos.writeUTF(name + " : " + scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}