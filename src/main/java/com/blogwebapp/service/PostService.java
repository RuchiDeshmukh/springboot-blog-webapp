package com.blogwebapp.service;

import java.util.List;

import com.blogwebapp.dto.PostDto;
import com.blogwebapp.entity.Post;

public interface PostService {
	
	List<PostDto> findAllPosts();
	
	void createPost(PostDto postDto);
	
	PostDto findPostById(Long postId);

	void updatePost(PostDto postDto);
	
	void deletePost(Long postId);

	PostDto findPostByUrl(String postUrl);
	
	List<PostDto> searchPosts(String query);
}
