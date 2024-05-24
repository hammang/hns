<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List, java.util.ArrayList, com.ohgiraffers.menu.model.dto.MenuDTO" %>
 <%
 	List<MenuDTO> menuList = (ArrayList<MenuDTO>) request.getAttribute("menuList");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse : collapse;
	}
	tr:not(:first-child):hover {
		background: orangered;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1 align="center">메뉴목록</h1>
	<table align="center">
		<tr>
			<th>메뉴코드</th>
			<th>메뉴이름</th>
			<th>메뉴가격</th>
			<th>카테고리코드</th>
			<th>판매상태</th>
		</tr>
		<% for(MenuDTO menu : menuList) { %>
		<tr class="items">
			<td><%= menu.getMenuCode() %></td>
			<td><%= menu.getMenuName() %></td>
			<td><%= menu.getMenuPrice() %></td>
			<td><%= menu.getCategoryCode() %></td>
			<td><%= menu.getOrderableStatus() %></td>
		</tr>
		<% } %>
	</table>
	<script>
		const items = document.querySelectorAll(".items");
		for(var i = 0; i < items.length; i++) {
			items[i].onclick = function() {
				const menuCode = this.children[0].innerText;
				location.href="/menu/detail?menuCode=" + menuCode;
			}
		}
	</script>
</body>
</html>