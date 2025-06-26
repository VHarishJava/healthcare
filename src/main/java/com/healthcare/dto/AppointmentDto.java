package com.healthcare.dto;

import java.util.Date;

import com.healthcare.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AppointmentDto {
	
	@Column(nullable=false)
	private Long doctorId;
	
	
	
	@Column(nullable=false)
	private Date appointmentDate;
	
	@Column(columnDefinition="TEXT")
	private String reason;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
