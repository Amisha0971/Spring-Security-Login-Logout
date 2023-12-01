package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;
	
	 
	@Autowired
	    private UserRepository userRepo;
	     
	    @RequestMapping("/test")
	    public String viewHomePage() {
	        return "index.html";
	    }
	    
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new User());
	         
	        return "signup_form";
	    }
	    
	    @PostMapping("/createUser")
		public String createUser(@ModelAttribute User u,HttpSession session)
		{
		 boolean f=userservice.checkEmail(u.getEmail());
		   if(f)
		   {
			   session.setAttribute("msg","Email Id Already Exist!");
			}else
			{
				User user= userservice.createUser(u);
				  if(user!=null)
				  {
					  session.setAttribute("msg","Resistered Succesfully!");  
				  }else
				  {
					  session.setAttribute("msg","Something Went Wrong!");
				  }
			}
		        return  "redirect:/register";
		        
		}
		
	    @RequestMapping("/SignIn")
		String SignIn()
		{
			return "login.html";
		}
	    
	    
	   
}



