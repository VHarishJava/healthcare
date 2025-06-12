package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.DoctorCreationRequest;
import com.healthcare.dto.Response;
import com.healthcare.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/createDoctor")
	public ResponseEntity<Response> createDoctor(@RequestBody @Valid DoctorCreationRequest doctor){
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Successfully Created Docdor",201,doctorService.createDoctor(doctor)));
	}
}
