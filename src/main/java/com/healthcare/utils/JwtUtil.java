package com.healthcare.utils;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	
	private final String SECRETE_KEY="HarishJavaDeveloperHarishJavaDeveloperHarishJaaDeveloper";
	

	public String generateToken(UserDetails userDetails, Long userId) {
		
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.claim("userId", userId)
				.claim("roles",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				 .map(role -> role.replace("ROLE_", "")).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, SECRETE_KEY)
				.compact(); 
	}
	
	
	public String extractUsername(String token) {
		return Jwts.parser()
				.setSigningKey(SECRETE_KEY)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public Long extractUserId(String token) {
		String userId= Jwts.parser()
				.setSigningKey(SECRETE_KEY)
				.parseClaimsJws(token)
				.getBody()
				.get("userId").toString();
		return Long.parseLong(userId);
	}
	
	public boolean isTokenExpired(String token) {
		return Jwts.parser()
				.setSigningKey(SECRETE_KEY)
				.parseClaimsJws(token)
				.getBody()
				.getExpiration()
				.before(new Date());
				
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		
		
		return extractUsername(token).equals(userDetails.getUsername()) && 
				!isTokenExpired(token);
		
		
		
		
	}
	
}
