package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AdminCreationRequest;
import com.healthcare.dto.Response;
import com.healthcare.model.Admin;
import com.healthcare.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/createAdmin", produces = "application/json")
	private ResponseEntity<Response> createAdmin(@RequestBody AdminCreationRequest admin){
		System.out.println("hi-------------------------------------------------"+admin);
		Admin createAdmin= adminService.createAdmin(admin);
		System.out.println("3-----------------------------------------------------------------"+createAdmin);
		Response response = new Response("Admin Successfully Created", 201, createAdmin);
		System.out.println("4-----------------------------------------------------------------"+response);
		
		return ResponseEntity.status(201).body(response);
}
}
