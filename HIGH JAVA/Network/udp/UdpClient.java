package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		// 송신용, 수신용 패킷객체 변수 선언
		DatagramPacket inpacket, outpacket;
		
		// 수신 받은 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[512];
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			// 접속할 곳의 주소 정보 생성
//			InetAddress address = InetAddress.getByName("localhost");
			InetAddress address = InetAddress.getByName("192.168.46.18");
			
			while (true) {
				// 전송할 메세지를 입력한다.
				System.out.print("보낼 메세지 입력 : ");
				String msg = scan.nextLine();
				
				if ("/end".equals(msg)) {  // 메세지 중지 여부 결정
					break;
				}
				
				// 전송용 패킷 객체 생성
				byte[] sendMsg = msg.getBytes("utf-8");
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, 8888);
				
				// 전송하기
				socket.send(outpacket);
				
				if ("/end".equals(msg)) {  // 메세지 중지 여부 결정
					break;
				}
				
				// 서버에서 온 데이터를 받아서 출력하기
				
				// 수신용 패킷객체 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 수신하기
				socket.receive(inpacket);
				
				String data = new String(bMsg, 0, bMsg.length, "utf-8");
				System.out.println("서버의 응답 데이터 : " + data);
				System.out.println();
				
			}  // while문 끝...
			
			System.out.println("통신 끝...");
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}







