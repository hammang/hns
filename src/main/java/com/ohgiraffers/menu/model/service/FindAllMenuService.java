package com.ohgiraffers.menu.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dao.MenuDAO;
import com.ohgiraffers.menu.model.dto.MenuDTO;

// 서비스의 역할
// 1. 컨트롤러로부터 값 전달 받기 (생략 가능)
// 2. 커넥션을 생성 (필수)
// 3. DAO 호출 (커넥션 전달, 값 전달) (필수)
// 4. 트랜젝션 관리 (insert, update, delete)
// 5. 커넥션 닫기 (필수)
// 6. 컨트롤러로 값 리턴 (생략 가능)
public class FindAllMenuService {
	
	public List<MenuDTO> findAllMenus() {
		
		// 커넥션 생성
		Connection con = Template.getConnection();
		
		//DAO 호출
		MenuDAO dao = new MenuDAO();
		List<MenuDTO> menuList = dao.findAllMenus(con);
		
		// 커넥션 닫기
		Template.close(con);
		
		// 컨트롤러로 값 리턴
		return menuList;
	}

}
