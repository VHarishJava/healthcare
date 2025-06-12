package com.healthcare.model;

import com.healthcare.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admin")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends Users{
	


	private Long adminId;
	
	public Admin(Long userId, String username, String password, Role role, String email) {
		super(userId, username, password, role, email);
	}
	
	

	public Admin(Long userId, String username, String password, Role role, String email, Long adminId) {
		super(userId, username, password, role, email);
		this.adminId = adminId;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}



	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}
	
	


	
	
	
	
	
	
	
	
	

}
