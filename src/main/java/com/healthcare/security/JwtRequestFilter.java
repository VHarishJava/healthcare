package com.healthcare.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.healthcare.service.CustomUserDetailsService;
import com.healthcare.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	
	@Autowired
	private JwtUtil jwtUtils;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		
		System.out.println("101010001010101010010100100101001010101010101010101010110100101101");
		System.out.println("Authorization Header: " + request.getHeader("Authorization"));

		
		final String authHeader = request.getHeader("Authorization");
		String username =null;
		String jwtToken=null;
		
		
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			jwtToken=authHeader.substring(7);
			try {
				username=jwtUtils.extractUsername(jwtToken);
			}catch(Exception e){
				
			}
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=customUserDetailsService.loadUserByUsername(username);
			
			if(jwtUtils.validateToken(jwtToken, userDetails)) {
				
				
				UsernamePasswordAuthenticationToken authToken=
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());	
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
