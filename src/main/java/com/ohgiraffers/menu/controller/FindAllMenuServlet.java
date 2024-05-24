package com.ohgiraffers.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.menu.model.dto.MenuDTO;
import com.ohgiraffers.menu.model.service.FindAllMenuService;

/**
 * Servlet implementation class FindAllMenuServlet
 */
@WebServlet("/findAll")
public class FindAllMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 컨트롤러
		// 1. 요청 받기 (전달된 값이 있으면 꺼내기)
		
		// 2. 비지니스 로직 호출 (C: insert, R: select, U: update, D: delete)
		// 객체 생성
		// 클래스명 사용할변수명 = new 클래스명();
		FindAllMenuService menuService = new FindAllMenuService();
		List<MenuDTO> menuList = menuService.findAllMenus();
		
		// 3. 클라이언트에게 응답
		request.setAttribute("menuList", menuList);
		RequestDispatcher rd = request.getRequestDispatcher("views/menuList.jsp");
		rd.forward(request, response);
	}

}
