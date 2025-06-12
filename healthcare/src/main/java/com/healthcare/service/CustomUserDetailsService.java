package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.healthcare.model.Users;
import com.healthcare.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Users users=userRepository.findByUsername(username);
		System.out.println("1------------------------------------");
		System.out.println(users);
		System.out.println("2------------------------------------");
		if(users==null) {
			return null;
		}

		return User.withUsername(username).password(users.getPassword())
				.roles(users.getRole().name()).build();
		
	}

}
