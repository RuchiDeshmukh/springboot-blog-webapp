package com.blogwebapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogwebapp.dto.CommentDto;
import com.blogwebapp.dto.PostDto;
import com.blogwebapp.service.PostService;

@Controller
public class BlogController {
	
	private PostService postService;

	public BlogController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping("/")
	public String viewBlogPosts(Model model) {
		List<PostDto> postsResponse = postService.findAllPosts();
		model.addAttribute("postsResponse", postsResponse);
		return "blog/view_posts";
	}
	
	@GetMapping("/post/{postUrl}")
	public String showPost(@PathVariable("postUrl") String postUrl, Model model) {
		PostDto postDto = postService.findPostByUrl(postUrl);
		
		CommentDto commentDto = new CommentDto();
		model.addAttribute("post", postDto);
		model.addAttribute("comment", commentDto);
		return "blog/blog_post";
	}
	
	@GetMapping("/post/search")
	public String searchPost(@RequestParam("query") String query, Model model) {
		
		List<PostDto> postsResponse = postService.searchPosts(query);
		model.addAttribute("postsResponse", postsResponse);
		return "blog/view_posts";
	}
}
