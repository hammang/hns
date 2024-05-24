package com.ohgiraffers.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohgiraffers.menu.model.dto.UserDTO;
import com.ohgiraffers.menu.model.service.SignInUserService;

@WebServlet("/signIn")
public class SignInUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/signIn.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//로그인 유저 정보 조회
		SignInUserService service = new SignInUserService();
		UserDTO loginUser = service.signIn(userId, userPwd);
		
		//세션 생성
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(loginUser);
		
		//index 화면으로 리다이랙트
		if(loginUser != null) {
			response.sendRedirect("/menu");			
		} else {
			response.sendRedirect("/menu/views/signInError.jsp");
		}
	}

}
