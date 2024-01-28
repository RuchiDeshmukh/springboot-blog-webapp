package com.blogwebapp.service;

import com.blogwebapp.dto.CommentDto;

public interface CommentService {

	void createComment(String postUrl, CommentDto commentDto);
}
