<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">신규 메뉴 정보 입력</h1>
	<form action="/menu/registMenu" method="POST" align="center">
		메뉴 이름 : <input name="menuName"><br>
		메뉴 가격 : <input type="number" name="menuPrice"><br>
		카테고리코드 : <input type="number" name="categoryCode"><br>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>