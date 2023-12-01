package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
   public boolean existsByEmail(String email);
	
	public User findByEmail(String email);
}