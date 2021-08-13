package kr.or.ddit.basic.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {
   public static void main(String[] args) {
      String serverIp = "localhost";
      
      System.out.println("서버 연결");
      
      try {
         Socket socket = new Socket(serverIp,7777);
         
         FileInputStream fis = new FileInputStream("d:/d_other/스폰지밥.png");
         OutputStream os = socket.getOutputStream();
      
         byte[] buffer = new byte[1024];
         int readBytes;
         while ((readBytes = fis.read(buffer)) != -1) {
                   os.write(buffer, 0, readBytes);
           }
           System.out.println("파일 전송 완료");
           fis.close();
           os.close();
           socket.close();
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}