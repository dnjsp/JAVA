package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*- 파일 전송하는 프로그램 작성하기
==> 서버와 클라이언트가 접속이 되면 클라이언트가 
   D:/D_Other/폴더에 있는 '스폰지밥.png'파일을 서버로 전송한다.
==> 서버는 클라이언트가 전송한 파일 데이터를 받아서 
   D:/D_Other/down/ 폴더에 같은 이름으로 저장한다.
*/

public class TcpFileClient1 {

   public static void main(String[] args) {
      TcpFileClient1 client = new TcpFileClient1();
      
      
      // 전송할 파일을 이용한 File객체 생성
//      File file = new File("D:/D_Other/짜짜짜.jpg");  // 지정된 파일
      File file = client.openDialog();  // 사용자 직접 선택
      
      
      if(file==null || !file.exists()) {      // 전송할 파일이 없으면 ~
         System.out.println("전송할 파일이 없습니다...ㅜ");
         System.out.println("전송 작업을 중단합니다.");
         return;
      }
      
      // 전송할 파일명 구하기
      String fileNm = file.getName();
      
      Socket socket = null;
      DataOutputStream dos = null;
      
      BufferedInputStream bis = null;
      BufferedOutputStream bos = null;
      
      
      try {
         socket = new Socket("192.168.46.51", 7777);
         System.out.println("파일 전송을 시작합니다람쥐@~@");
         
         // 소켓용 OutputStream객체를 구한다.
         OutputStream out = socket.getOutputStream();
         dos = new DataOutputStream(out);
         
         // 서버에 접속하면 첫번째로 파일명을 전송한다.
         dos.writeUTF(fileNm);
         
         // 파일 내용을 읽어와서 소켓으로 출력한다.
         bis = new BufferedInputStream(new FileInputStream(file));    // 입력용 스트림(파일)
         bos = new BufferedOutputStream(out);      // 출력용 스트림(소켓)
         
         byte[] temp = new byte[1024];
         int length = 0;
         
         // 파일 내용을 읽어와 소켓을 통해서 전송한다.
         while((length = bis.read(temp)) > 0) {
            bos.write(temp, 0, length);
         }
         bos.flush();
         
         System.out.println("파일 전송이 완료되엇ㅅ흐미다~#~`@");
         
          
      } catch (Exception e) {
         System.out.println("파일 전송 실패ㅠㅜㅠㅜ");
         e.printStackTrace();
      } finally {
         if(dos != null) try { dos.close(); } catch (IOException e) {}
         if(bos != null) try { bos.close(); } catch (IOException e) {}
         if(bis != null) try { bis.close(); } catch (IOException e) {}
         if(socket != null) try { socket.close(); } catch (IOException e) {}
      }
      

//      try {
//         Socket socket = new Socket("192.168.46.23", 7777);
//         System.out.println("서버에 연결되었습니다.");
//         File file = new File("C:\\Users\\PC-19\\Desktop\\명수홀릭\\입닫빵.jpg");
//         OutputStream fout = socket.getOutputStream();
//         FileInputStream fin = new FileInputStream(file);
//         
//         int data;
//         
//         
//         while ((data = fin.read()) != -1) {
//            fout.write(data);
//         }
//         
//      } catch (Exception e) {
//         // TODO: handle exception
//      }

      
   }
   
   private File openDialog() {
      // SWING의 파일 열기, 저장 창 연습
            JFileChooser chooser = new JFileChooser();
            
            // 보여줄 파일의 확장자 설정
            FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[] {"png","jpg","gif"});
            FileNameExtensionFilter txt = new FileNameExtensionFilter("Text File", "txt");
            FileNameExtensionFilter doc = new FileNameExtensionFilter("Ms-Word문서", "docx", "doc");
            
            chooser.addChoosableFileFilter(img);
            chooser.addChoosableFileFilter(txt);
            chooser.addChoosableFileFilter(doc);
            
            //확장자 목록 중에 기본적으로 선택될 확장자 지정
            chooser.setFileFilter(txt);
            
            // 전체 파일 목록(*.*) 표시 여부 설정(true:설정, false:해제)
            chooser.setAcceptAllFileFilterUsed(true);
            
            // DIalog창에 나타날 기본 경로 설정
            chooser.setCurrentDirectory(new File("d:/d_other"));
            

            //열기용 창
            int result = chooser.showOpenDialog(new Panel());
            
            //저장용 창
//            int result = chooser.showSaveDialog(new Panel());
            File selectedFile = null;
            // '저장' 또는 '열기' 버튼을 눌렀을 경우의 처리하기
            if(result==JFileChooser.APPROVE_OPTION) {
               
               // 선택한 파일 객체 구하기
               selectedFile = chooser.getSelectedFile();
               //System.out.println("선택한 파일 : "+ selectedFile.getAbsolutePath());
            }
            return selectedFile;
         }

}