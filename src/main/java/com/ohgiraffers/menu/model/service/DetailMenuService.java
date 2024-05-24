package com.ohgiraffers.menu.model.service;

import java.sql.Connection;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dao.MenuDAO;
import com.ohgiraffers.menu.model.dto.MenuDTO;

public class DetailMenuService {

	public MenuDTO findOneMenu(int menuCode) {
		
		Connection con = Template.getConnection();
		
		MenuDAO dao = new MenuDAO();
		MenuDTO menu = dao.findOneMenu(con, menuCode);
		
		Template.close(con);
		
		return menu;
	}

}
