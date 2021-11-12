<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 창</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#memListBtn").on("click", function(){
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	});
	
	// 중복확인
	$("#idCheckBtn").on("click", function(){
		const mem_id = $("#mem_id").val();
		if (mem_id == "") {
			alert("ID를 입력하세요.");
			return;
		}
		
		$.ajax({
			url : "<%=request.getContextPath()%>/member/memberIdCheck.do",
			data : { "mem_id" : mem_id },
			type : "post",
			dataType : "json",
			success : function(result){
				if (result == "OK") {
					$("#idCheckResult").html("사용가능");
				} else {
					$("#idCheckResult").html("ID중복 - 사용불가")
				}
			},
			error : function(xhr){
				alert("status : " + xhr.status);
			}
		});
	});
	
	// form의 데이터를 전송하기 전에 입력한 데이터 검증하기
	$("#memberFrom").on("submit", function(){
		// 중복 확인 여부 검사
		let idChk = $("idCheckResult").html();
		if (idChk != "사용가능") {
			alert("ID가 중복되거나 중복 체크를 하지 않았습ㄴ디ㅏ.");
			return false;	// 서버로의 데이터 전송을 중단한다.
		}
		
		if ($("#mem_pass").val() != $("#mem_pass2").val()) {
			alert("비밀번호와 비밀번호 확인이 서로 다릅니다. 다시 확인하세요.");
			return false;
		}
		
		return true;  // 서버로 전송
		
	});
	
});
</script>
</head>
<body>
<h2>회원 정보 입력 폼</h2>
<form method="post" action="<%=request.getContextPath()%>/member/memberInsert.do">
<table border="1">
<tr>
	<td>회원ID</td>
	<td>
		<input type="text" name="mem_id" id="mem_id">
		<input type="button" value="중복확인" id="idCheckBtn">
		<span id="idCheckResult"></span>
	</td>
</tr>
<tr>
	<td>비민번호</td>
	<td><input type="password" name="mem_pass" id="mem_pass"></td>
</tr>
<tr>
	<td>비민번호 확인</td>
	<td><input type="password" name="mem_pass2" id="mem_pass2"></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><input type="text" name="mem_name" id="mem_name"></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><input type="text" name="mem_tel" id="mem_tel"></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><input type="text" name="mem_addr" id="mem_addr"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="저장">
		<input type="reset" value="취소">
		<input type="button" id="memListBtn" value="회원목록">
	</td>
</tr>
</table>
</form>
</body>
</html>