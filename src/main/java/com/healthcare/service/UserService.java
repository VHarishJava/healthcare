package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Users;
import com.healthcare.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository userRepository;

	public Users getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
