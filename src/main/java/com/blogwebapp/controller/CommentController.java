package com.blogwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogwebapp.dto.CommentDto;
import com.blogwebapp.dto.PostDto;
import com.blogwebapp.service.CommentService;
import com.blogwebapp.service.PostService;

import jakarta.validation.Valid;

@Controller
public class CommentController {
	
	private CommentService commentService;
	private PostService postService;
	
	public CommentController(CommentService commentService, PostService postService) {
		super();
		this.commentService = commentService;
		this.postService = postService;
	}


	@PostMapping("/{postUrl}/comments")
	public String createComment(@PathVariable("postUrl") String postUrl, 
								@Valid @ModelAttribute("comment") CommentDto commentDto, 
								BindingResult bindingResult,
								Model model) {
		PostDto postDto = postService.findPostByUrl(postUrl);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("comment", commentDto);
			model.addAttribute("post", postDto);
			return "blog/blog_post";
		}
		commentService.createComment(postUrl, commentDto);
		
		return "redirect:/post/"+postUrl;
	}

}
