package com.blogwebapp.service;

import java.util.List;

import com.blogwebapp.dto.CommentDto;

public interface CommentService {

	void createComment(String postUrl, CommentDto commentDto);

	List<CommentDto> findAllComments();

	void deleteComment(Long commentId);
	
	List<CommentDto> findCommentsByPost();
	
}
