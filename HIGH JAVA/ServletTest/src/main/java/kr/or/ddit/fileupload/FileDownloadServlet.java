package kr.or.ddit.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload.do")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 	파일을 다운로드하는 과정
	 	1. FileInputStream 객체를 이용해서 다운로드할 파일을 서버에서 읽는다. 
	 	2. 파일을 다운로드하려면 response객체의 setContentType()메서드를 이용하여 content-type을 
	 	   'application/octet-stream; charset=utf-8'로 설정한다. 
	 	3. response객체의 헤더를 다음과 같이 설정한다. 
	 		1) 헤더명 : "Content-Disposition"
	 		2) 헤더값 : 'attachment; filename="다운로드할파일명";'
		4. response객체의 getOutputStream()을 사용하여 출력할 스트림 객체를 구한 후 
			이 출력 스트림으로 전송하면 된다. 
		
	 */

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 다운로드 할 파일 이름을 구한다. 
		String fileName = request.getParameter("filename");
		
		// 파일이 저장된 폴더 설정
		 String uploadPath = "D:\\D_Other\\uploadFiles";
		 
		 // 파일 경로와 파일명을 연결한 전체 파일 경로를 만든다. 
		 String filePath = uploadPath + File.separator + fileName;
		 
		 File file = new File(filePath);
		 
		 OutputStream os = null;
		 FileInputStream fis = null; 
		 
		 if(file.exists()) { // 다운로드할 파일이 있을 때 
			// Content-Type 설정하기 
			 response.setContentType("application/octet-stream; charset=utf-8");
			 
			// response의 헤더설정 
			// String headerValue = "attachment; filename=\""+ fileName + "\"";
			 
			 String headerValue = "attachment; filename=\""+ getDisposition(fileName,getBrowser(request)) + "\"";
			 response.setHeader("Content-Disposition", headerValue);
			 
			 try {
				// 출력용 스트림 객체 생성
				 os = response.getOutputStream();
				 
				// 파일 입력용 스트림 객체 생성
				 fis = new FileInputStream(file);
				 
				 byte[] buffer = new byte[1024*100];
				 int len = -1;
				 while((len=fis.read(buffer))>0) {
					 os.write(buffer, 0, len);
				 }
				 os.flush();
				 
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(fis!=null) try {	fis.close();} catch (IOException e) {}
				if(os!=null) try { os.close();} catch (IOException e) {}
			}
			 
		 }else { // 다운로드할 파일이 없을 때 
			response.setContentType("text/html; charset=utf-8" );
			response.getWriter().println("<h3>" + fileName + "파일은 존재하지 않습니다. </h3>");
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	// 사용자의 웹브라우저 알아내는 메서드
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		//System.out.println(header);
		
		if(header.indexOf("MSIE") > -1 ) {
			return "MSIE";
		}else if(header.indexOf("Chrome") >-1) {
			return "Chrome";
		}else if(header.indexOf("Opera") >-1) {
			return "Opera";
		}else if(header.indexOf("Trident/7.0") >-1) { // IE 11 이상
			return "MSIE";
		}
		return "Firefox";
	}
	
	
	// 브라우저별로 한글 파일명을 인코딩하는 메서드 
	private String getDisposition(String fileName, String browser) {
		String encodedFilename = null; 
		try {
			if(browser.equals("MSIE")) {
				encodedFilename = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
			}else if(browser.equals("Firefox")  || browser.equals("Opera")) {
				encodedFilename = "\"" + new String(fileName.getBytes("utr-8"), "8859_1") + "\"";
			}else if(browser.equals("Chrome")) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < fileName.length(); i++) {
					char c = fileName.charAt(i);
					if (c > '~') {
						sb.append(URLEncoder.encode("" + c, "utf-8"));
					}else {
						sb.append(c);
					}
				}
				encodedFilename = sb.toString();
				
			}else {
				throw new RuntimeException("지원하지 않는 브라우저입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encodedFilename;
	}
	
}


