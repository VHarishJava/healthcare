package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dto.AdminCreationRequest;
import com.healthcare.enums.Role;
import com.healthcare.model.Admin;
import com.healthcare.model.Users;
import com.healthcare.repository.AdminRepository;
import com.healthcare.repository.UsersRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	
	
	public Admin createAdmin(AdminCreationRequest admin) {
		Admin newAdmin =new Admin();
		newAdmin.setUsername(admin.getAdminName());
		newAdmin.setPassword(admin.getAdminPassword());
		
		newAdmin.setRole(Role.ADMIN);

		 return adminRepository.save(newAdmin);
	}

}
