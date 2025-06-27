package com.healthcare.dto;

import java.util.Date;

import com.healthcare.model.Appointment;

public class AppointmentResponseDto {
    private Long id;
    private String doctorName;
    private String patientName;
    private Date date;
    private String status;
    private String reason;

    // Constructor
    public AppointmentResponseDto(Appointment appointment) {
        this.id = appointment.getAppointmentId();
        this.doctorName = appointment.getDoctor().getUsername(); // assuming doctor has getUsername()
        this.patientName = appointment.getPatient().getUsername(); // assuming patient has getUsername()
        this.date = appointment.getAppointmentDate();
        this.status = appointment.getAppointmentStatus().name();
        this.reason = appointment.getReason();
    }

	public AppointmentResponseDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "AppointmentResponseDto [id=" + id + ", doctorName=" + doctorName + ", patientName=" + patientName
				+ ", date=" + date + ", status=" + status + ", reason=" + reason + "]";
	}

}
