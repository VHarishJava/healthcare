package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dto.DoctorCreationRequest;
import com.healthcare.enums.Role;
import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor createDoctor(DoctorCreationRequest doctor) {
		Doctor newDoctor=new Doctor();
	newDoctor.setEmail(doctor.getDoctorEmail());
	newDoctor.setPassword(doctor.getDoctorPassword());
	newDoctor.setSpecialization(doctor.getDoctorSpecialization());
	newDoctor.setUsername(doctor.getDoctorName());
	newDoctor.setRole(Role.DOCTOR);
	return doctorRepository.save(newDoctor);
	}
	
	
	
	
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	
	public Optional<Doctor> getById(Long id) {
		return doctorRepository.findById(id);
	}
	
	
	
	
	public void deleteById(Long id) {
		Optional<Doctor> doctor =doctorRepository.findById(id);
		if(doctor.isPresent())
		 doctorRepository.deleteById(id);
	}

}
