package com.blogwebapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blogwebapp.dto.PostDto;
import com.blogwebapp.entity.Post;
import com.blogwebapp.entity.User;
import com.blogwebapp.mapper.PostMapper;
import com.blogwebapp.repository.PostRepository;
import com.blogwebapp.repository.UserRepository;
import com.blogwebapp.service.PostService;
import com.blogwebapp.util.SecurityUtils;

@Service
public class PostServiceImpl  implements PostService{

	private PostRepository postRepository;
	private UserRepository userRepository;
	
	public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<PostDto> findAllPosts() {
		List<Post> posts =  postRepository.findAll();
		
		return  posts.stream().map(post -> PostMapper.mapToPostDto(post)).collect(Collectors.toList());
		
	}

	@Override
	public void createPost(PostDto postDto) {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepository.findByEmail(email);
		Post post = PostMapper.mapToPost(postDto);
		post.setCreatedBy(user);
		postRepository.save(post);
	}

	@Override
	public PostDto findPostById(Long postId) {
		Post post = postRepository.findById(postId).get();
		return PostMapper.mapToPostDto(post);
	}

	@Override
	public void updatePost(PostDto postDto) {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User user = userRepository.findByEmail(email);
		Post post = PostMapper.mapToPost(postDto);
		post.setCreatedBy(user);
		postRepository.save(post);
	}

	@Override
	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}

	@Override
	public PostDto findPostByUrl(String postUrl) {
		Post post = postRepository.findByUrl(postUrl).get();
		return PostMapper.mapToPostDto(post);
	}

	@Override
	public List<PostDto> searchPosts(String query) {
		List<Post> posts = postRepository.searchPosts(query);
		return posts.stream()
				    .map(PostMapper :: mapToPostDto)
				    .collect(Collectors.toList());
	}

	@Override
	public List<PostDto> findPostsByUser() {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User createdBy = userRepository.findByEmail(email);
		List<Post> posts = postRepository.findPostsByUser(createdBy.getId());
		return posts.stream()
					.map((post)->PostMapper.mapToPostDto(post))
					.collect(Collectors.toList());
	}

	
}
