<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ohgiraffers.menu.model.dto.MenuDTO"%>
<%
	MenuDTO menu = (MenuDTO) request.getAttribute("menu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">메뉴 상세 정보</h1>
	<h3 align="center">메뉴 이름 : <%= menu.getMenuName() %></h3>
	<h4 align="center">메뉴 가격 : <%= menu.getMenuPrice() %></h4>
</body>
</html>