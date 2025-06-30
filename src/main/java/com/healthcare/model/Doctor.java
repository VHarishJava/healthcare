package com.healthcare.model;

import com.healthcare.enums.Role;

import jakarta.persistence.Entity;


import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity

@Table(name="doctor")

@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends Users{

	

	
	private String specialization;
	
	
	

	public Doctor() {
		
	}

	public Doctor(Long userId, String username, String password, Role role, String email) {
		super(userId, username, password, role, email);
	}

	public Doctor(Long userId, String username, String password, Role role, String email, String specialization) {
		super(userId, username, password, role, email);
		this.specialization = specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
	    return "Doctor [userId=" + getUserId() + ", username=" + getUsername() + ", specialization=" + specialization + "]";
	}
	
	
}
