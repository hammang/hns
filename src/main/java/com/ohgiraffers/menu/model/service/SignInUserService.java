package com.ohgiraffers.menu.model.service;

import java.sql.Connection;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dao.UserDAO;
import com.ohgiraffers.menu.model.dto.UserDTO;

public class SignInUserService {

	public UserDTO signIn(String userId, String userPwd) {
		
		Connection con = Template.getConnection();
		
		UserDAO dao = new UserDAO();
		UserDTO loginUser = dao.signIn(con, userId, userPwd);
		
		Template.close(con);
		
		return loginUser;
	}

}
