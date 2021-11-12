package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	이 예제는 애노테이션을 이용해서 Servlet을 설정하여 처리하는 예제이다.
 	사용할 애노테이션은 @WebServlet이고 이것은 servlet버전 3.0이상에서 사용할 수 있다.
 	
 	@WebServlet애노테이션의 속성들
 	1. name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열(""))
 	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다. (기본값 : 빈배열({}))
 	   예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 지정할 패턴이 1개일 경우
 	   예) urlPatterns={"/url1", "/url2", ...} ==> 지정할 패턴이 여러개일 경우
 	3. value : urlPatterns와 동일한 기능을 한다.
 	4. description : 주석(설명글)을 설정한다.
 */

@WebServlet(description = "애노테이션을 이용한 서블릿 설정 예제", urlPatterns = {"/servlet02.do"})
public class ServletTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// doGet()메서드 --> GET방식의 요청을 처리하는 메서드
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setCharacterEncoding("utf-8"); // 응답문서의 인코딩 방식 지정
			response.setContentType("text/html; charset=UTF-8"); // 응답문서의 ContentType 설정
			
			// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체를 생성한다.
			// ( response객체를 이용한다. )
			PrintWriter out = response.getWriter();
			
			// 처리한 내용을 출력한다.
			
			// 방법2 : print()메서드 또는 println()메서드 이용하기
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>두 번째 Servlet 연습 </title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1 style='text-align: center;'>");
			out.println("안녕하세요. 두 번째 Servlet프로그램 입니다.<br>");
			out.println("애노테이션을 이용한 서블릿 설정 예제입니다..<br>");
			out.println("Served at : " + request.getContextPath());
			out.println("</h1>");
			out.println("</body>");
			out.println("</html>");

		}
		
		@Override
		// doPost()메서드 --> POST방식의 요청을 처리하는 메서드
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.doPost(request, response);
		}
}
