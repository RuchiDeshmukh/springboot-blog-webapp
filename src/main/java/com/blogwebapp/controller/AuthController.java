package com.blogwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogwebapp.dto.RegistrationDto;
import com.blogwebapp.entity.User;
import com.blogwebapp.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	private UserService userService;
	
	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
	public String loginPage() {
		
		
		return "login";
	} 
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		
		//this object holds form data
		RegistrationDto user = new RegistrationDto();
		model.addAttribute("user", user);
		return "register";
		
	}
	
	@PostMapping("/register/save")
	public String register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model) {
		
		User existingUser = userService.findByEmail(user.getEmail());
		
		if(existingUser != null) {
			result.rejectValue("email", null,"There is already user with same email id.");
		}
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		
		userService.saveUser(user);

		return "redirect:/register?success";
	}
	
	
}
