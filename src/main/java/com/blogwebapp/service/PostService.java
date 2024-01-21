package com.blogwebapp.service;

import java.util.List;

import com.blogwebapp.dto.PostDto;

public interface PostService {
	
	List<PostDto> findAllPosts();
	

}
