package com.blogwebapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blogwebapp.dto.CommentDto;
import com.blogwebapp.entity.Comment;
import com.blogwebapp.entity.Post;
import com.blogwebapp.entity.User;
import com.blogwebapp.mapper.CommentMapper;
import com.blogwebapp.repository.CommentRepository;
import com.blogwebapp.repository.PostRepository;
import com.blogwebapp.repository.UserRepository;
import com.blogwebapp.service.CommentService;
import com.blogwebapp.util.SecurityUtils;

@Service
public class CommentServiceImpl implements CommentService{
	
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}



	@Override
	public void createComment(String postUrl, CommentDto commnetDto) {
		Post post = postRepository.findByUrl(postUrl).get();
		Comment comment = CommentMapper.mapToComment(commnetDto);
		comment.setPost(post);
		commentRepository.save(comment);
		
	}



	@Override
	public List<CommentDto> findAllComments() {
		List<Comment> comments = commentRepository.findAll();
		
		return comments.stream()
					   .map(CommentMapper :: mapToCommentDto)
					   .collect(Collectors.toList());
	}



	@Override
	public void deleteComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}



	@Override
	public List<CommentDto> findCommentsByPost() {
		String email = SecurityUtils.getCurrentUser().getUsername();
		User createdBy = userRepository.findByEmail(email);
		Long userId = createdBy.getId();
		List<Comment> comments = commentRepository.findCommentsByPost(userId);
		return comments.stream()
					   .map(comment-> CommentMapper.mapToCommentDto(comment))
					   .collect(Collectors.toList());
	}

}
