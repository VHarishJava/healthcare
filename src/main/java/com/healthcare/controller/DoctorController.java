package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.DoctorCreationRequest;
import com.healthcare.dto.Response;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.DoctorService;
import com.healthcare.service.PatientService;
import com.healthcare.utils.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/doctors")
	
	public ResponseEntity<Response> createDoctor(@RequestBody @Valid DoctorCreationRequest doctor){
		
		
		String password=passwordEncoder.encode(doctor.getDoctorPassword());
		
		doctor.setDoctorPassword(password);
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Successfully Created Doctor",201,doctorService.createDoctor(doctor)));
	}
	
	@GetMapping("/doctors")
	public ResponseEntity<Response> getAllDoctorsToPatients(){
		return 	ResponseEntity.ok().body(new Response("Suuceessfully Fetched All Doctors", 201, doctorService.getAllDoctors()));
		
	}
	
}
