package com.healthcare.service;

import java.util.List;
import java.util.Optional;

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
		
		newPatient.setUsername(patient.getPatientName());
		newPatient.setPassword(patient.getPatientPassword());
		newPatient.setRole(Role.PATIENT);
		
		return patientRepository.save(newPatient);
		
	}
	
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
		
	}
	
	public void deleteById(Long id) {
		Optional<Patient> patient= patientRepository.findById(id);
		if(patient.isPresent()) {
		 patientRepository.deleteById(id);
		}
		
	}
	
	public Patient getById(Long id) {
		Optional<Patient> existPatient= patientRepository.findById(id);
		Patient	patient=null;
		if(existPatient.isPresent()) {
			patient	=existPatient.get();
			
		return patient;
		}
		return null;
		
	}
	
	
}
