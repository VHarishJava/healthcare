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

import com.healthcare.dto.AdminCreationRequest;
import com.healthcare.dto.Response;
import com.healthcare.model.Admin;
import com.healthcare.service.AdminService;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.DoctorService;
import com.healthcare.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping(value = "/createAdmin", produces = "application/json")
	public ResponseEntity<Response> createAdmin(@RequestBody @Valid AdminCreationRequest admin){
		final String password=passwordEncoder.encode(admin.getAdminPassword());
		admin.setAdminPassword(password);
		Admin createAdmin= adminService.createAdmin(admin);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new Response("Admin Successfully Created", 201, createAdmin));		
}
	
	
	@GetMapping("/patients")
	public ResponseEntity<Response> getAllPatients(){
		return ResponseEntity.status(200)
				.body(new Response("Successfully Fetched Patient Details", 200, patientService.getAllPatients()));
	}
	
	
	@GetMapping("/doctors")
	public ResponseEntity<Response> getAllDoctors(){
		return ResponseEntity.status(200)
				.body(new Response("Successfully Fetch Doctors",200,doctorService.getAllDoctors()));
	}
	
	@GetMapping("/appointment")
	public ResponseEntity<Response> getAllAppointment(){
		return ResponseEntity.status(200)
				.body(new Response("Successfully Fetch Appoinitments",200,appointmentService.getAllAppointments()));
	}
	
	
}
