package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
	private UserRepository repo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		
		User u=repo.findByEmail(email);
		
	   if(u!=null)
	   {
		   return new CustomUserDetails(u);
	   }
		
	   throw new UsernameNotFoundException("user not found");
		   
		   
	}

}
