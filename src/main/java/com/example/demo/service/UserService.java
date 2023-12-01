package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

    public User createUser(User u) {
		u.setPassword(passwordEncode.encode(u.getPassword()));
		u.setRole("ROLE_USER");
		
		return repo.save(u);
	}
    
   public boolean checkEmail(String email) {
		
		return repo.existsByEmail(email);
	}
   
   public List<User> getAllUser() {
		
		return repo.findAll();
	   }
}
