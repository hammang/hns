<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">회원 가입</h1>
	<form action="/menu/signUp" method="post" align="center">
		회원이름 : <input type="text" name="userName"><br>
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="password" name="userPwd"><br>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>