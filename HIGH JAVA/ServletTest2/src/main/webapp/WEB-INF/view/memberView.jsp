<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#memListBtn").on("click", function(){
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	});
	
	// 수정 버튼 클릭
	$("#updateBtn").on("click", function(){
		$("#memberForm").attr("method", "get");
		$("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberUpdate.do");
		$("#memberForm").submit();  // form데이터 전송
	});
	
	// 삭제 버튼 클릭
	$("#deleteBtn").on("click", function(){
		$("#memberForm").attr("method", "post");
		$("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberDelete.do");
		$("#memberForm").submit();  // form데이터 전송
	});
});
</script>
</head>
<body>
<%
	MemberVO memVO = (MemberVO) request.getAttribute("memberVO");
%>
<h2>회원 정보 상세 보기</h2>
<form method="post" id="memberForm" action="">
<input type="hidden" name="mem_id" value="<%=memVO.getMem_id()%>">
<table border="1">
<tr>
	<td>회원ID</td>
	<td><%=memVO.getMem_id() %></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><%=memVO.getMem_pass() %></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><%=memVO.getMem_name() %></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><%=memVO.getMem_tel() %></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><%=memVO.getMem_addr() %></td>
</tr>

<tr>
	<td colspan="2" style="text-align:center;">
		<input type="button" id="updateBtn" value="수정"/>
		<input type="button" id="deleteBtn" value="삭제"/>
		<input type="button" id="memListBtn" value="회원목록"/>
	</td>
</tr>
</table>
</form>
</body>
</html>