package com.healthcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.healthcare.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth-> auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/registration/**").permitAll()
				
				.requestMatchers("/admin/**").permitAll()
				.requestMatchers("/student/**").hasRole("STUDENT")
				.requestMatchers("/tutor/**").hasRole("TUTOR")
				.anyRequest().authenticated()
				
				)
		.formLogin()
		.and()
		.httpBasic();
	
	return http.build();
	}
	
	
	@Bean
	public PasswordEncoder encoderPassword() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
