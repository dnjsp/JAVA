<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Login 창</title>
</head>
<body>

<%
   // 쿠키 정보 가져오기
   
   String cookieUserId = "";
   String chk = ""; // 체크박스의 체크용
   Cookie[] cookies = request.getCookies(); //쿠키생성
   if(cookies != null && cookies.length > 0) {
      for(Cookie cookie : cookies){
         // checkbox처리에 관련된 쿠키변수 찾기
         if(cookie.getName().equals("userId")){
            cookieUserId = cookie.getValue(); // 쿠키값 가져오기
            chk = "checked";
         }
      }
//      for (int i = 0; i < cookies.length; i++){
//         if (cookies[i].getName().equals("userId")) { // 내가 원하는 쿠키명 찾아서 값 저장
//            cookie = cookies[i].getValue();
//         }
//      }
   }
%>
            
<form method="post" action="<%=request.getContextPath()%>/cookieLoginServlet.do">
   <table style="margin: auto auto; ">
      <tr>
         <td>ID : </td>
         <td><input type="text" name="id" placeholder="아이디를 입력하세요"
         value="<%=cookieUserId%>"></td>
      </tr>
      <tr>
         <td>PASS : </td>
         <td><input type="password" name="pw" placeholder="비밀번호를 입력하세요"
         value=""></td>
      </tr>
      <tr>
         <td colspan="2">
            <input type="checkbox" name="IDholder" value="chked" <%=chk%>> ID 기억하기
         </td>
      </tr>
      <tr>
         <td colspan="2" style="text-align: center;">
            <input type="submit" value="LOGIN">
         </td>
      </tr>
   </table>
</form>
</body>
</html>