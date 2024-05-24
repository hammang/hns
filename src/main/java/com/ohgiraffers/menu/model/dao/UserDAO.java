package com.ohgiraffers.menu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dto.UserDTO;

public class UserDAO {
/*	
	CREATE TABLE `tbl_user` (
			`user_code`	int auto_increment NOT NULL primary key,
			`user_name`	varchar(30)	NOT NULL,
			`user_id`	varchar(30)	NOT NULL,
		    `user_pwd`  varchar(30) NOT NULL,
		    `activation_status` varchar(3) default 'Y'
		);
*/

	public int signUpUser(Connection con, UserDTO user) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into tbl_user values (null, ?, ?, ?, 'Y')";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPwd());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
		}
		
		return result;
	}

	public UserDTO signIn(Connection con, String userId, String userPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserDTO loginUser = null;
		
		String query = "select * from tbl_user where user_id = ? and user_pwd = ? and activation_status = 'Y'";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new UserDTO();
				loginUser.setUserCode(rset.getInt("user_code"));
				loginUser.setUserName(rset.getString("user_name"));
				loginUser.setUserId(rset.getString("user_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
			Template.close(rset);
		}
		
		return loginUser;
	}

}
