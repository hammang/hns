package com.ohgiraffers.menu.model.dto;

// DTO 작성방법
// 1. 모든 필드는 private로 지정
// 2. 기본 생성자, 모든 필드 초기화하는 생성자
// 3. 모든 필드에 대한 setter/getter 작성
// 4. toString 메소드 오버라이딩
public class MenuDTO {

// desc 테이블명;
// 컬럼명, 자료형 고려해서 필드 작성
//	menu_code	int(11)
//	menu_name	varchar(30)
//	menu_price	int(11)
//	category_code	int(11)
//	orderable_status	char(1)
	
	private int menuCode;
	private String menuName;
	private int menuPrice;
	private int categoryCode;
	private String orderableStatus;
	
	// 기본 생성자
	public MenuDTO() {}

	public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.categoryCode = categoryCode;
		this.orderableStatus = orderableStatus;
	}

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getOrderableStatus() {
		return orderableStatus;
	}

	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [menuCode=" + menuCode + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", categoryCode=" + categoryCode + ", orderableStatus=" + orderableStatus + "]";
	}
	
	
	
}
