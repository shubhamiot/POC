package com.cg.pizza.delivery.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.pizza.delivery.model.Admin;
import com.cg.pizza.delivery.repository.AdminRepository;

@Service
@Transactional
public class AdminService {

	private  final AdminRepository adminRepository;
	
	 public AdminService(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}
	 
	 public Admin findByUsernameAndPassword(String username, String password) {
			return adminRepository.findByUsernameAndPassword(username, password);
		}
}
