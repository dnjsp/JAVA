<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login 창</title>
</head>
<%
	// 세션 정보를 가져온다.
	// ==> JSP문서에서는 HttpSession객체는 session이라는 이름으로 만들어져 있다.
	// 해당 세션의 'key값'이 없으면 null이 반환된다.
	String userId = (String)session.getAttribute("id");
%>
<body>
<%
if(userId == null) {
%>

<!-- 로그인이 안 되었을 때 화면 구성 시작 -->

	<form method="post" action="<%=request.getContextPath()%>/sessionLogin.do">
	<table border="1" style="margin: auto auto;">
		<tr>
			<td>ID : </td>
			<td>
				<input type="text" name="userid" placeholder="ID를 입력하세요">
			</td>
		</tr>
		<tr>
			<td>PASS : </td>
			<td>
				<input type="password" name="pass" placeholder="Password를 입력하세요">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Login" name="btn">
			</td>
		</tr>			
	</table>
	</form>

<!-- 로그인이 안 되었을 때 화면 구성 끝 -->

<%
} else {
%>

<!-- 로그인이 성공했을 때 화면 구성 시작 -->

	<h3><%=userId %>님 반갑습니다.</h3>
	<a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
   
<!-- 로그인이 성공했을 때 화면 구성 끝 -->

<%
}
%>

</body>
</html>








