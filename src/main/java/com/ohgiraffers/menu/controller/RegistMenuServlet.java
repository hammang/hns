package com.ohgiraffers.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.menu.model.dto.MenuDTO;
import com.ohgiraffers.menu.model.service.RegistMenuService;

@WebServlet("/registMenu")
public class RegistMenuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/registMenu.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 값 받기
		String menuName = request.getParameter("menuName");
		int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		
		System.out.println(menuName);
		System.out.println(menuPrice);
		System.out.println(categoryCode);
		
		// 2. 비지니스 로직 전달
		RegistMenuService service = new RegistMenuService();
		
		MenuDTO menu = new MenuDTO();
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		menu.setCategoryCode(categoryCode);
		
		int result = service.registMenu(menu);
		
		// 3. 응답
		if(result > 0) {
			//성공 페이지로 연결
			response.sendRedirect("/menu/views/success.jsp");
		} else {
			//에러 페이지로 연결
			response.sendRedirect("/menu/views/error.jsp");
		}
	}

}
