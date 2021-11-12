package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이미지 파일을 읽어오는 Servlet
@WebServlet("/img/imageView.do")
public class ImageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("filename");
		
		String downloadPath = "C:\\ddit\\D_Other\\uploadFiles";
		String filePath = downloadPath + File.separator + fileName;
		File file = new File(filePath);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		if (file.exists()) {
			try {
				// 출력용 스트림 객체 생성 ==> response객체 이용
				bos = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] buffer = new byte[1024];
				int len = -1;
				
				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림 객체로 출력한다.
				while((len = bis.read(buffer)) > 0) {
					bos.write(buffer, 0, len);
				}
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if (bos != null) try { bos.flush(); bos.close(); } catch (IOException e) {}
				if (bis != null) try { bis.close(); } catch (IOException e) {}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
