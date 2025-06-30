package com.healthcare.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dto.AppointmentDto;
import com.healthcare.dto.AppointmentResponseDto;
import com.healthcare.enums.AppointmentStatus;
import com.healthcare.model.Appointment;
import com.healthcare.model.Doctor;
import com.healthcare.model.Patient;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public List<AppointmentResponseDto> getAppointmentByPatientId(Long id) {
		List<Appointment> appointment=	appointmentRepository.findByPatient_UserId(id);
		return appointment.stream().map(AppointmentResponseDto::new).collect(Collectors.toList());
	}

	
	public List<AppointmentResponseDto> getAppointmentByDoctorId(Long id) {
		List<Appointment> appointments= appointmentRepository.findByDoctor_UserId(id);
		return appointments.stream().map(AppointmentResponseDto::new).collect(Collectors.toList());
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}



public Appointment createAppointment(AppointmentDto appointmentDto, Long userId) {
	System.out.println("Appointment Service");
   
    Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId())
            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + appointmentDto.getDoctorId()));
//System.out.println("*****************************************************"+doctor);
  
    Patient patient = patientRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Patient not found with id " + userId));
//    System.out.println("*****************************************************"+patient);
    
    Appointment appointment = new Appointment(
        doctor,
        patient,
        AppointmentStatus.REQUESTED, 
        appointmentDto.getAppointmentDate(),
        appointmentDto.getReason()
    );
    return appointmentRepository.save(appointment);
}
	
	
	
	public AppointmentResponseDto updateAppointmentStatus( AppointmentStatus status, Long appointmentId) {
		
		Optional<Appointment> appointmentExist=appointmentRepository.findById(appointmentId);
		Appointment appointment = null;
		if(appointmentExist.isPresent()) {
			appointment=	appointmentExist.get();
		}
		appointment.setAppointmentStatus(status);
		
		
		return new AppointmentResponseDto(appointmentRepository.save(appointment));
	}
	
}
