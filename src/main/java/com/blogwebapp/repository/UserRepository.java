package com.blogwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogwebapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
