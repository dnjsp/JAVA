<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestTest</title>
</head>
<body>
	<h1>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h1>
	<form name="testForm" method="post" action="<%=request.getContextPath() %>/RequestTest02.do">
		<table>
			<tr>
				<td><input type="text" size="10" name="num1"></td>
				<td>
					<select name="operator">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
						<option value="%">%</option>
					</select>
				</td>
				<td><input type="text" size="10" name="num2"></td>
				<td>
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>