package com.ohgiraffers.menu.model.service;

import java.sql.Connection;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dao.UserDAO;
import com.ohgiraffers.menu.model.dto.UserDTO;

public class SignUpUserService {

	public int signUpUser(UserDTO user) {
		
		//커넥션 생성
		Connection con = Template.getConnection();
		
		//DAO 호출
		UserDAO dao = new UserDAO();
		int result = dao.signUpUser(con, user);
		System.out.println(result);
		//트랜젝션 제어
		if(result > 0) {
			Template.commit(con);
		} else {
			Template.rollback(con);
		}
		
		//커넥션 닫기
		Template.close(con);
		
		return result;
	}
	
	

}
