	package com.healthcare.model;
	
	import java.util.Date;

import com.healthcare.enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name="appointments")
	public class Appointment {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long appointmentId;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "doctor_user_id", nullable = false)  // foreign key column name in appointments table
		private Doctor doctor;
;
		
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "patient_user_id", nullable = false)  // foreign key column name in appointments table
private Patient patient;

	
		
		@Enumerated(EnumType.STRING)
		@Column(nullable=false)
		private AppointmentStatus appointmentStatus =AppointmentStatus.REQUESTED;
		
		@Column(nullable=false)
		private Date appointmentDate;
		
		@Column(columnDefinition="TEXT")
		private String reason;
		
		@Column( updatable=false)
		private Date createdAt;
	
		
		
		
		
		
		
		
		
		public Appointment() {
			super();
		}









		public Appointment( Doctor doctor, Patient patient, AppointmentStatus appointmentStatus,
				Date appointmentDate, String reason) {
			super();
			
			this.doctor = doctor;
			this.patient = patient;
			this.appointmentStatus = appointmentStatus;
			this.appointmentDate = appointmentDate;
			this.reason = reason;
			
		}









		public Long getAppointmentId() {
			return appointmentId;
		}









		public void setAppointmentId(Long appointmentId) {
			this.appointmentId = appointmentId;
		}









		public Doctor getDoctor() {
			return doctor;
		}









		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}









		public Patient getPatient() {
			return patient;
		}









		public void setPatient(Patient patient) {
			this.patient = patient;
		}









		public AppointmentStatus getAppointmentStatus() {
			return appointmentStatus;
		}









		public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
			this.appointmentStatus = appointmentStatus;
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









		public Date getCreatedAt() {
			return createdAt;
		}









		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
	
		
	
		
		
	
	}
