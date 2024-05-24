<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ohgiraffers.menu.model.dto.UserDTO"%>
<%
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">홈페이지 예시</h1>
	<div class="login-area" align="right">
		<% if(loginUser == null) { %>
		<button onclick="signUp()">회원가입</button>
		<button onclick="signIn()">로그인</button>
		<% } else { %>
		<h3><%= loginUser.getUserName() %>님 환영합니다.</h3>
		<button onclick="logout()">로그아웃</button>
		<% } %>
	</div>
	<div class="nav-area" align="center">
		<button onclick="findAllMenu()">전체 메뉴 조회하기</button>
		<button onclick="registMenu()">신규 메뉴 등록하기</button>
	</div>
	<script>
		function signUp() {
			location.href = '/menu/signUp';
		}
		
		function signIn() {
			location.href = '/menu/signIn';
		}
		
		function logout() {
			location.href="/menu/logout";
		}
		
		function findAllMenu() {
			location.href = '/menu/findAll';
		}
		
		function registMenu() {
			location.href = "/menu/registMenu";
		}
	</script>
</body>
</html>