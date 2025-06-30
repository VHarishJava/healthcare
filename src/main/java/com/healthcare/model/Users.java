package com.healthcare.model;

import com.healthcare.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Table(name="users")


@Inheritance(strategy=InheritanceType.JOINED)
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	private String username;
	
	private String password;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Role role;
	
	private String email;

	public Users(Long userId, String username, String password, Role role, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
	}

	public Users() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", role=" + role
				+ ", email=" + email + "]";
	}

	
	
	
	
	
}
