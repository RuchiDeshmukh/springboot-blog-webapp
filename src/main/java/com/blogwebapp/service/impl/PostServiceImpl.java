package com.blogwebapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blogwebapp.dto.PostDto;
import com.blogwebapp.entity.Post;
import com.blogwebapp.mapper.PostMapper;
import com.blogwebapp.repository.PostRepository;
import com.blogwebapp.service.PostService;

@Service
public class PostServiceImpl  implements PostService{

	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	@Override
	public List<PostDto> findAllPosts() {
		List<Post> posts =  postRepository.findAll();
		
		return  posts.stream().map(post -> PostMapper.mapToPostDto(post)).collect(Collectors.toList());
		
	}

}
