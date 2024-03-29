package com.blogwebapp.service.impl;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogwebapp.dto.RegistrationDto;
import com.blogwebapp.entity.Role;
import com.blogwebapp.entity.User;
import com.blogwebapp.repository.RoleRepository;
import com.blogwebapp.repository.UserRepository;
import com.blogwebapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void saveUser(RegistrationDto registrationDto) {
		User user = new User();
		user.setName(registrationDto.getFirstName()+" "+registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		//user spring security to encrypt password
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		
		Role role = roleRepository.findByName("ROLE_GUEST");
		user.setRoles(Arrays.asList(role));
		
		userRepository.save(user);
	}


	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}

