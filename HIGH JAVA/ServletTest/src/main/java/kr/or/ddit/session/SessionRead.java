package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");

      PrintWriter out = response.getWriter();
      // 저장된 Session 정보 읽어오기

      // 1. Session 정보 읽어오기
      HttpSession session = request.getSession();

      out.println("<!DOCTYPE html>");
      out.println("<html><head><meta charset='UTF-8'>");
      out.println("<title>Session 연습</title></head>");
      out.println("<body>");
      out.println("<h2>저장된 Session 정보 확인하기</h2><hr>");
      
      out.println("<h3>저장된 Session 정보들 중에서 원하는 Session값 1개 가져오기</h3><br>");
      // 2. 개별적인 Session값 가져오기 
      // 형식) session객체.getAttribute("key값");
      //       => 해당 'key값'이 있으면 그 'key값'에 맞는 Session값이 반환되고
      //         'key값'이 없으면 null이 반환된다.
      String sessionValue = (String) session.getAttribute("testSession");
      
      if(sessionValue==null) {
         out.append("<h3>testSession의 세션값이 없습니다.</h3>");
      }else {
         out.append("<h3>testSession의 세션값 : " + sessionValue + "</h3>");
      }
      out.append("<br><hr><br>");
      
      out.append("<h3>전체 세션 데이터 확인하기</h3>");
      out.append("<ol>");
      // 현재 Session에 저장된 객체 'key값들'을 구한다.
      Enumeration<String> sessionKeys = session.getAttributeNames();
      
      int cnt = 0;
      while(sessionKeys.hasMoreElements()) {
         cnt++;
         // 세션의 key값 구하기
         String sessionKey = sessionKeys.nextElement();
         out.append("<li>" + sessionKey + " : " 
                  + session.getAttribute(sessionKey) + "</li>");
      }
      if(cnt==0) {
         out.append("<li>세션 데이터가 하나도 없습니다.</li>");
      }
      out.append("</ol>");
      out.append("<br><hr><br>");
      out.append("<h3>기타 Session관련 정보들</h3>");
      
      // 세션 ID => 세션을 구분하기 위한 고유한 값
      out.append("세션 ID : " + session.getId() + "<br>");
      
      // 생성시간과 접근 시간은 단위가 밀리세컨드 단위이고
      // 1970년1월1일부터 경과한 시간을 나타낸다.
      out.append("세션 생성 시간 : " + session.getCreationTime() + "<br>");
      out.append("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
      
      // 초단위의 값이 반환된다.
      out.append("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br><hr><br>");
      // 유효시간 설정 => session.setMaxInactiveInterval(초 단위 시간); 

      out.println("<a href='" + request.getContextPath() + "/03/sessionTest.jsp'>시작문서로 이동하기</a>");
      out.println("</body></html>");

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}