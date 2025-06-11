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
	
	
	private final String SECRETE_KEY="hari";
	

	public String generateToken(UserDetails userDetails) {
		
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.claim("roles",userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, SECRETE_KEY)
				.compact(); 
	}
	
	
	public String extractUsername(String token) {
		return Jwts.parser()
				.setSigningKey(SECRETE_KEY)
				.parseClaimsJwt(token)
				.getBody()
				.getSubject();
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
