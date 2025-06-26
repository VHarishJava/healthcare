package com.healthcare.dto;

public class PatientCreateRequest {

	
	private String patientAge;
	private String patientGender;
	private String patientName;
	private String patientMobile;
	private String patientPassword;
	private String patientEmail;
	
	
	
	
	
	public PatientCreateRequest() {
		super();
	}





	public PatientCreateRequest(String patientAge, String patientGender, String patientName, String patientMobile,
			String patientPassword, String patientEmail) {
		super();
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientName = patientName;
		this.patientMobile = patientMobile;
		this.patientPassword = patientPassword;
		this.patientEmail = patientEmail;
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





	public String getPatientName() {
		return patientName;
	}





	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}





	public String getPatientMobile() {
		return patientMobile;
	}





	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}





	public String getPatientPassword() {
		return patientPassword;
	}





	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}





	public String getPatientEmail() {
		return patientEmail;
	}





	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}





	@Override
	public String toString() {
		return "PatientCreateRequest [patientAge=" + patientAge + ", patientGender=" + patientGender + ", patientName="
				+ patientName + ", patientMobile=" + patientMobile + ", patientPassword=" + patientPassword
				+ ", patientEmail=" + patientEmail + "]";
	}
	
	
	
	
	

}
