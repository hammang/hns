package com.ohgiraffers.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.menu.model.dto.MenuDTO;
import com.ohgiraffers.menu.model.service.DetailMenuService;

@WebServlet("/detail")
public class DetailMenuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int menuCode = Integer.parseInt(request.getParameter("menuCode"));
		
		DetailMenuService service = new DetailMenuService();
		MenuDTO menu = service.findOneMenu(menuCode);
		
		request.setAttribute("menu", menu);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/detail.jsp");
		rd.forward(request, response);
	}
}
