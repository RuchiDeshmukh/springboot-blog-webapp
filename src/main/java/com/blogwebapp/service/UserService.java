package com.blogwebapp.service;

import com.blogwebapp.dto.RegistrationDto;
import com.blogwebapp.entity.User;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);

	User findByEmail(String email);
}
