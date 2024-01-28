package com.blogwebapp.service.impl;

import org.springframework.stereotype.Service;

import com.blogwebapp.dto.CommentDto;
import com.blogwebapp.entity.Comment;
import com.blogwebapp.entity.Post;
import com.blogwebapp.mapper.CommentMapper;
import com.blogwebapp.repository.CommentRepository;
import com.blogwebapp.repository.PostRepository;
import com.blogwebapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	
	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}



	@Override
	public void createComment(String postUrl, CommentDto commnetDto) {
		Post post = postRepository.findByUrl(postUrl).get();
		Comment comment = CommentMapper.mapToComment(commnetDto);
		comment.setPost(post);
		commentRepository.save(comment);
		
	}

}
