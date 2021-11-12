package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// id, password, checkbox의 값을 받아온다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String checkbox = request.getParameter("IDholder");
		
		// 사용자 ID를 지정한 쿠키객체 생성
		Cookie cookie = new Cookie("userId", id);
		
		/*
		if (checkbox != null) {  // checkbox가 체크된 상태이다.
			response.addCookie(cookie);  // 쿠키 저장
		} else {  // checkbox가 해제된 상태이다.
			cookie.setMaxAge(0);  // 쿠키의 유효시간을 0으로 설정해서 바로 삭제되도록 한다.
			response.addCookie(cookie);
		}
		*/
	
		if (checkbox == null) {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		// 로그인 성공 여부 검사 (id:test, password:1234)
		if((id != null) && (pw != null)) {
			if(id.equals("test") && pw.equals("1234")) {  // 로그인 성공
				response.sendRedirect(request.getContextPath() + "/02/cookieMain.jsp");
			} else {  // 로그인 실패
				response.sendRedirect(request.getContextPath() + "/02/cookieLogin.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
