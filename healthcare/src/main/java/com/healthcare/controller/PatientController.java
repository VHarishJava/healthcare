package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.PatientCreateRequest;
import com.healthcare.dto.Response;

import com.healthcare.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	public ResponseEntity<Response> createPatient(@RequestBody @Valid PatientCreateRequest patientCreateRequest){

		
		return 	ResponseEntity.ok().body(new Response("Patient Created", 201, 	patientService.createPatient(patientCreateRequest)));
	
	}
	
}
