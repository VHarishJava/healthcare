package com.healthcare.dto;

public class DoctorCreationRequest {
	
	private String doctorName;
	private String doctorPassword;
	private String doctorSpecialization;
	private String doctorEmail;
	
	
	public DoctorCreationRequest(String doctorName, String doctorPassword, String doctorSpecialization, String doctorEmail) {
		super();
		this.doctorName = doctorName;
		this.doctorPassword = doctorPassword;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorEmail = doctorEmail;
	}


	public DoctorCreationRequest() {
		super();
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorPassword() {
		return doctorPassword;
	}


	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}


	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}


	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	@Override
	public String toString() {
		return "DoctorRequest [doctorName=" + doctorName + ", doctorPassword=" + doctorPassword
				+ ", doctorSpecialization=" + doctorSpecialization + ", doctorEmail=" + doctorEmail + "]";
	}
	
	
	

}
