package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResponse;
import com.healthcare.service.CustomUserDetailsService;
import com.healthcare.service.UserService;
import com.healthcare.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService ;

	
	@Autowired
	private JwtUtil jwtUtils;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> authentication(@RequestBody AuthRequest auth){
		System.out.println(auth);
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(auth.getUsername(),auth.getPassword())
					);
			
		}catch(BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Invalid Credentials"));
		}
		
		final UserDetails userDetails=customUserDetailsService.loadUserByUsername(auth.getUsername());
		System.out.println("userDetails"+userDetails);
		
		final Long userId=userService.getUserByUsername(userDetails.getUsername()).getUserId();
		System.out.println("userId"+userId);
		
		final String token =jwtUtils.generateToken(userDetails,userId);
		System.out.println("token"+token);
		
		return ResponseEntity.ok(new AuthResponse(token));
		
		
	}

}
