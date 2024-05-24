package com.ohgiraffers.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohgiraffers.menu.model.dto.UserDTO;
import com.ohgiraffers.menu.model.service.SignUpUserService;

@WebServlet("/signUp")
public class SignUpUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("views/signUp.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 값 꺼내기
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		
		// 비지니스 로직 호출
		SignUpUserService service = new SignUpUserService();
		
		UserDTO user = new UserDTO();
		user.setUserName(userName);
		user.setUserId(userId);
		user.setUserPwd(userId);
		
		int result = service.signUpUser(user);
		
		if(result > 0) {
			response.sendRedirect("/menu/views/signUpSuccess.jsp");
		} else {
			response.sendRedirect("/menu/views/signUpError.jsp");
		}
		
	}

}
