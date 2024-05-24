package com.ohgiraffers.menu.model.service;

import java.sql.Connection;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dao.MenuDAO;
import com.ohgiraffers.menu.model.dto.MenuDTO;

public class RegistMenuService {

	public int registMenu(MenuDTO menu) {
		
		Connection con = Template.getConnection();
		
		MenuDAO dao = new MenuDAO();
		int result = dao.registMenu(con, menu);
		
		if(result > 0) {
			//커밋
			Template.commit(con);
		} else {
			//롤백
			Template.rollback(con);
		}
		
		Template.close(con);
		
		return result;
	}

}
