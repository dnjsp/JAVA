package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

// 이 클래스는 소켓에서 메세지를 받아 화면에 출력하는 역할을 담당하는 쓰레드 클래스이다.
public class Receiver extends Thread {
	@SuppressWarnings("unused")
	private Socket socket;
	private DataInputStream dis;
	
	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			// 입력용 스트림 객체 생성
			dis = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while (dis != null) {
			try {
				// 데이터를 받아서 화면에 출력하기
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
