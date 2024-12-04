<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Work2gether Login</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employeeLoginForm.css"/>
</head>
<body>
	<div class="main-div">
		<div class="logo">
			<img id="logoImg" alt="logo" src="${pageContext.request.contextPath}/resources/sneat-1.0.0/assets/img/layouts/logo.png"/>
		</div>
		<form method="post">
			<div class="form-group">
					<div class="input-area">
						<input type="text" placeholder="사번" name="empId"/>
						<input type="password" placeholder="비밀번호" name="empPass"/>
					</div>
					<div class="button-area">
						<button type="submit">LOGIN</button>
					</div>
			</div>
		</form>
		<div class="links">
			<a href="#">비밀번호 찾기</a> | <a href="#">회원가입</a>
		</div>
	</div>
</body>
</html>
