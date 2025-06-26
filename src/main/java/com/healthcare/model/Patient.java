package com.healthcare.model;

import com.healthcare.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="patient")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Patient extends Users {

	

	
	private String patientAge;
	
	private String patientGender;
	
	

	
	private String patientMobile;




	public Patient(Long userId, String username, String password, Role role, String email, 
			String patientAge, String patientGender, String patientMobile) {
		super(userId, username, password, role, email);
		
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientMobile = patientMobile;
	}




	public Patient(Long userId, String username, String password, Role role, String email) {
		super(userId, username, password, role, email);
	}




	public Patient() {
		// TODO Auto-generated constructor stub
	}




	



	public String getPatientAge() {
		return patientAge;
	}




	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}




	public String getPatientGender() {
		return patientGender;
	}




	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}




	public String getPatientMobile() {
		return patientMobile;
	}




	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}




	@Override
	public String toString() {
		return "Patient [patientAge=" + patientAge + ", patientGender=" + patientGender + ", patientMobile="
				+ patientMobile + ", UserId=" + getUserId() + ", Username=" + getUsername()
				+  ", getRole()=" + getRole() + ", getEmail()=" + getEmail()
				+ "]";
	}





	

	

}
