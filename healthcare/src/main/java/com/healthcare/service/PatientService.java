package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dto.PatientCreateRequest;
import com.healthcare.enums.Role;
import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public Patient createPatient(PatientCreateRequest patient) {
		
		Patient newPatient =new Patient();
		
		newPatient.setEmail(patient.getPatientEmail());
		
		newPatient.setPatientAge(patient.getPatientAge());
		
		newPatient.setPatientGender(patient.getPatientGender());
		
		newPatient.setPatientMobile(patient.getPatientMobile());
		
		newPatient.setUsername(patient.getPatientMobile());
		newPatient.setPassword(patient.getPatientPassword());
		newPatient.setRole(Role.PATIENT);
		
		return patientRepository.save(newPatient);
		
	}
	
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
		
	}
	
	
	
	
	
	
}
