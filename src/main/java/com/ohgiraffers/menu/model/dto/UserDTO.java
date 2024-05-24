package com.ohgiraffers.menu.model.dto;

public class UserDTO {
	
	private int userCode;
	private String userName;
	private String userId;
	private String userPwd;
	private String activationStatus;
	
	public UserDTO() {}

	public UserDTO(int userCode, String userName, String userId, String userPwd, String activationStatus) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.activationStatus = activationStatus;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	@Override
	public String toString() {
		return "UserDTO [userCode=" + userCode + ", userName=" + userName + ", userId=" + userId + ", userPwd="
				+ userPwd + ", activationStatus=" + activationStatus + "]";
	}
	
}
