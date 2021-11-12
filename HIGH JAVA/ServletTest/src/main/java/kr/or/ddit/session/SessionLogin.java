package kr.or.ddit.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		// 로그인이 성공하면 세션에 로그인 정보를 저장한다.
		if ("admin".equals(userId) && "1234".equals(pass)) {
			session.setAttribute("id", userId);
		}
		
		response.sendRedirect(request.getContextPath() + "/03/sessionLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
