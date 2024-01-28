package com.blogwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogwebapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
