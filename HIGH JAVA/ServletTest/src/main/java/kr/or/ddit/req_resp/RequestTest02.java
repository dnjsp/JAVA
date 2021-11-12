package kr.or.ddit.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST방식으로 전달되는 문자의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 입력한 숫자 2개와 연산자를 받아온다.
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		String operator = request.getParameter("operator");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = 0; // 계산될 결과가 저장될 변수
		boolean calcOk = true; // 계산 성공 여부가 저장될 변수 (true: 계산 성공)
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");
		
		out.println("<h1>계산 결과</h1>");
		out.print(num1 + " " + operator + " " + num2 + " = ");
		
		if (operator.equals("+")) {
			result = num1 + num2;
			out.println(result);
		} else if (operator.equals("-")) {
			result = num1 - num2;
			out.println(result);
		} else if (operator.equals("*")) {
			result = num1 * num2;
			out.println(result);
		} else if (operator.equals("/")) {
			result = num1 / num2;
			out.println(result);
		} else if (operator.equals("%")) {
			result = num1 % num2;
			out.println(result);
		}
		
//		out.println("<hr>");
//		out.println("<h2>Request 테스트 결과 2</h2>");
//		out.println("<ol>");
//		out.println("<li>클라이언트 주소 : " + request.getRemoteAddr() + "</li>");
//		out.println("<li>요청 메서드 : " + request.getMethod() + "</li>");
//		out.println("<li>Context Path : " + request.getContextPath() + "</li>");
//		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
//		out.println("<li>URL 정보 : " + request.getRequestURL() + "</li>");
//		out.println("<li>URI 정보 : " + request.getRequestURI() + "</li>");
//		out.println("</ol>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
