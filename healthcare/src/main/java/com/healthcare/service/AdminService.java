package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dto.AdminCreationRequest;
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
		System.out.println("Service==----------------------------------------------------------------------------------------------------------------------");
		Admin newAdmin =new Admin();
		newAdmin.setUsername(admin.getAdminName());
		newAdmin.setPassword(admin.getAdminPassword());
		
		System.out.println("2-----------------------------------------------------------------");
		 return adminRepository.save(newAdmin);
	}

}
