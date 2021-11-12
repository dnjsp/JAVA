package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	- 서블릿의 동작 과정 (Servlet의 LifeCycle)
 	
 	1. 사용자(클라이언트)가 URL을 클릭하면 HTTP Request를 Servlet Container에게 전송(요청)한다.
 
 	2. 컨테이너는 web.xml에 정의된 url패턴을 확인하여 어느 서블릿을 통해 처리해야 할지를 검색한다.
 	   (이 때 로딩이 안 된 경우에는 로딩 작업으르 수행하는데 처음 로딩시에는 init()메서드를 호츨한다.)
 	   (servlet버전 3.0이상에서는 애노테이션(@WebServlet)으로 설정한다.)
 	
 	3. Servlet Container는 요청을 처리할 개별 쓰레드 객체를 생성하여 해당 서블릿 객체의 service()메서드를 호출한다.
 	   (이 때 HttpServletRequest객체와 HttpServletResonse객체를 생성해서 파라미터로 넘겨준다.)
 	
 	4. service()메서드는 method 타입을 체크하여 적절한 메서드를 호출한다.
 	   (doGet(), doPost(), doPut(), doDelete()등)
 	
 	5. 해당 메서드에서 요청 처리가 완료되면 처리된 결과를 응답으로 보내준다.
 	   (이 때 HttpServletRequest객체와 HttpServletResponse객체는 소멸된다.)
 	
 	6. 컨테이너로부터 서블릿이 제거되는 경우에는 destory()메서드가 호출된다.
 */

@WebServlet("/ServletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet : " + 
				"에서 init()메서드를 호출합니다.");
	}

	public void destroy() {
		System.out.println("Servlet : " + 
				"에서 destroy()메서드를 호출합니다...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()메서드 시작...");
		// super.service(req, resp);
		
		// 클라이언트의 전송방식(GET, POST)을 구분해서 직접 메서드 호출하기
		String method = req.getMethod();
		System.out.println("method = " + method);
		
		if ("GET".equals(method)) {
			doGet(req, resp);
		} else {
			doPost(req, resp);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작...");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body><h1>doGet()메서드 처리 결과입니다.!!!!!!!</h1></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작...");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body><h1>doPost()메서드 처리 결과입니다.!!!!!!!</h1></body></html>");
	}

}