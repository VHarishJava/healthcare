package com.healthcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.healthcare.security.JwtRequestFilter;
import com.healthcare.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	 @Autowired
	    private JwtRequestFilter jwtRequestFilter;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth-> auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/registration/**","/patient/registration").permitAll()
				.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
				.requestMatchers("/admin/**").permitAll()
				
				
				.requestMatchers("/doctor/doctors").permitAll()
				.requestMatchers("/student/**").hasRole("STUDENT")
				.requestMatchers("/tutor/**").hasRole("TUTOR")
				.requestMatchers("/tutor/**").hasRole("TUTOR")
				
				.anyRequest().authenticated()
				
				)
		 .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
         .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		
//		.formLogin()
//		.and()
//		.httpBasic()
		;
	
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
