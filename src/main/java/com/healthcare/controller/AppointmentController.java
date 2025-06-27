package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AppointmentDto;
import com.healthcare.dto.Response;
import com.healthcare.enums.AppointmentStatus;
import com.healthcare.service.AppointmentService;
import com.healthcare.utils.JwtUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/appointments")
@SecurityRequirement(name="BearerAuth")
public class AppointmentController {

	
	@Autowired
	private  AppointmentService appointmentService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/patient")
	@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<Response> getAllPatientAppointments(@RequestHeader("Authorization") String authHeader){
		
		 String token = authHeader.substring(7);
		 
		Long patientId=jwtUtil.extractUserId(token);
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new Response("Successfully fetched Doctor's Appoinments",
						200,
						appointmentService.getAppointmentByPatientId(patientId)));
		
	}
	
	
	
	
	@GetMapping("/doctor")
	@PreAuthorize("hasRole('DOCTOR')")
	public ResponseEntity<Response> getAllDoctorAppointments(@RequestHeader("Authorization") String authHeader){
		System.out.println("authHeader:  "+authHeader);
		  String token = authHeader.substring(7);
		Long doctorId=jwtUtil.extractUserId(token);
		System.out.println("doctorId:  "+doctorId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new Response("Successfully fetched Doctor's Appoinments",
						200,
						appointmentService.getAppointmentByDoctorId(doctorId)));
		
	}
	
	
	
	
	
	
	
	
	@PostMapping("/appoinment")
//	@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<Response> createAppointment(@RequestHeader("Authorization") String authHeader,
			@RequestBody AppointmentDto appointment ){
		System.out.println("Appointment controller");
		System.out.println("authHeader: " + authHeader);
		Long userId=jwtUtil.extractUserId(authHeader.substring(7));
		
		System.out.println(" patientId "+userId);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new Response("Successfully created Appoinment",
						200,
						appointmentService.createAppointment(appointment,userId)));
		
	}
	
	
	
	
	
	
	@PutMapping
	@PreAuthorize("hasRole('DOCTOR')")
	public ResponseEntity<Response> updateAppointmentStatus(@RequestHeader("Authorization") String authHeader,
			@RequestParam AppointmentStatus status, @RequestParam Long appointmentId){
		  String token = authHeader.substring(7);
		Long doctorId=jwtUtil.extractUserId(token);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Successfully update Appointment Status",
				200,appointmentService.updateAppointmentStatus( status, appointmentId)
				));
	}
	
	
	
	
	
	
	
}









