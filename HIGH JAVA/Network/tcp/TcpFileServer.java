package kr.or.ddit.basic.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
   public static void main(String[] args) {
      try {
         ServerSocket server = new ServerSocket(7777);
         
         Socket socket = server.accept();
         FileOutputStream output = new FileOutputStream("d:/d_other/스폰지.png");
         InputStream is = socket.getInputStream();

         byte[] buffer = new byte[1024];
         int readBytes;
            while ((readBytes = is.read(buffer)) != -1) {
               output.write(buffer, 0, readBytes);
 
            }     
            System.out.println("파일 수신 완료");
            output.close();
            is.close();
            socket.close();
            server.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}