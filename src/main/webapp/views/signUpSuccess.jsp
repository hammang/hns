<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 성공!</h1>
	<button onclick="goHome()">홈으로</button>
	<script>
		function goHome() {
			location.href="/menu";
		}
	</script>
</body>
</html>