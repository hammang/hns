package com.ohgiraffers.menu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ohgiraffers.menu.common.Template;
import com.ohgiraffers.menu.model.dto.MenuDTO;

// DAO의 역할
// 데이터베이스에서 SQL 실행 후 서비스로 반환
// 단 1개의 메소드는 1개의 SQL만 실행
public class MenuDAO {

	public List<MenuDTO> findAllMenus(Connection con) {
		
		// SQL 실행 준비
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 리스트 준비
		List<MenuDTO> menuList = null;
		
		// SQL 준비
		String query = "select * from tbl_menu";
		
		// SQL 실행
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			// 여러 행의 결과를 담기 위해 리스트 생성
			menuList = new ArrayList<MenuDTO>();
			
			// 조회한 한 줄에 해당하는 정보를 한 DTO에 담고
			// 조회한 모든 줄을 ArrayList에 담기
			while(rset.next()) {
				// 한 줄씩 읽어서 DTO에 담기
				MenuDTO row = new MenuDTO();
				row.setMenuCode(rset.getInt("menu_code"));
				row.setMenuName(rset.getString("menu_name"));
				row.setMenuPrice(rset.getInt("menu_price"));
				row.setCategoryCode(rset.getInt("category_code"));
				row.setOrderableStatus(rset.getString("orderable_status"));
				
				menuList.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
			Template.close(rset);
		}
		
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}	
		return menuList;
	}

	public int registMenu(Connection con, MenuDTO menu) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into tbl_menu values (null, ?, ?, ?, 'Y')";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menu.getMenuName());
			pstmt.setInt(2, menu.getMenuPrice());
			pstmt.setInt(3, menu.getCategoryCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
		}
		
		return result;
	}

	public MenuDTO findOneMenu(Connection con, int menuCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MenuDTO menu = null;
		
		String query = "select * from tbl_menu where menu_code = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, menuCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				menu = new MenuDTO();
				menu.setMenuCode(rset.getInt("menu_code"));
				menu.setMenuName(rset.getString("menu_name"));
				menu.setMenuPrice(rset.getInt("menu_price"));
				menu.setCategoryCode(rset.getInt("category_code"));
				menu.setOrderableStatus(rset.getString("orderable_status"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
			Template.close(rset);
		}
		
		return menu;
	}

}
