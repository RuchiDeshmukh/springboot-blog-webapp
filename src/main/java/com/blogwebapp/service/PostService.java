package com.blogwebapp.service;

import java.util.List;

import com.blogwebapp.dto.PostDto;

public interface PostService {
	
	List<PostDto> findAllPosts();
	
	List<PostDto> findPostsByUser();
	
	void createPost(PostDto postDto);
	
	PostDto findPostById(Long postId);

	void updatePost(PostDto postDto);
	
	void deletePost(Long postId);

	PostDto findPostByUrl(String postUrl);
	
	List<PostDto> searchPosts(String query);
}
