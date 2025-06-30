package com.healthcare.model;

import com.healthcare.enums.Role;

import jakarta.persistence.Entity;

import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")

@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends Users{

	
	
	
	
	
	public Admin() {
	
		
		
	}

	public Admin(Long userId, String username, String password, Role role, String email) {
		super(userId, username, password, role, email);
	}

	@Override
	public String toString() {
		return "Admin [UserId()=" + getUserId() + ", Username()=" + getUsername() + 
				", Role()=" + getRole() + ", Email()=" + getEmail() + ", toString()="+ "]";
	}
	


	
	

}
