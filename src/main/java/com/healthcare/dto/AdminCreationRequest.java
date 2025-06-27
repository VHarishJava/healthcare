package com.healthcare.dto;

import lombok.Data;

@Data
public class AdminCreationRequest {
	
	private String adminName;
	private String adminPassword;
	
	
	
	public AdminCreationRequest() {
		super();
	}
	public AdminCreationRequest(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "AdminCreationRequest [adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	

}
