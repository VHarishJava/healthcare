package com.healthcare.dto;

public class AuthRequest {

	
	private String username;
	
	private String password;

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AuthRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthRequest [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
