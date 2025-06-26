package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.PatientCreateRequest;
import com.healthcare.dto.Response;
import com.healthcare.service.DoctorService;
import com.healthcare.service.PatientService;
import com.healthcare.utils.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	@PostMapping("/registration")
	public ResponseEntity<Response> createPatient(@RequestBody @Valid PatientCreateRequest patientCreateRequest){

		String password=passwordEncoder.encode(patientCreateRequest.getPatientPassword());
		
		
		patientCreateRequest.setPatientPassword(password);
		
		return 	ResponseEntity.ok().body(new Response("Patient Created", 201, 	patientService.createPatient(patientCreateRequest)));
	
	}
	

	
	
		
	}
	
	
	
	
	
	

