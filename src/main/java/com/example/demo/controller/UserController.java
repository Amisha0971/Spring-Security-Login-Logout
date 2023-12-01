package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
 
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String home()
   {
	   return "UserPage.html";
   }
	
	@ModelAttribute
	private String data(Model m,Principal p)
	{
		String email=p.getName();
		User u=repo.findByEmail(email);
		
		m.addAttribute("u",u);
		return"UserPage.html";
	}
	
}
