package com.blogwebapp.mapper;

import java.util.stream.Collectors;

import com.blogwebapp.dto.PostDto;
import com.blogwebapp.entity.Post;

public class PostMapper {
	
	//map post entity to post dto
	public static PostDto mapToPostDto(Post post){
		
		PostDto postDto = PostDto.builder()
								 .id(post.getId())
								 .title(post.getTitle())
								 .url(post.getUrl())
								 .content(post.getContent())
								 .shortDescription(post.getShortDescription())
								 .createdOn(post.getCreatedOn())
								 .updatedOn(post.getUpdatedOn())
								 .comments(post.getComments()
										 		.stream()
										 		.map(comment-> CommentMapper.mapToCommentDto(comment))
										 		.collect(Collectors.toSet()))
								 .build();
		
		return postDto;
	}
	
	//map PostDto to post entity
	public static Post mapToPost(PostDto postDto){
		
		Post post= Post.builder()
								 .id(postDto.getId())
								 .title(postDto.getTitle())
								 .url(postDto.getUrl())
								 .content(postDto.getContent())
								 .shortDescription(postDto.getShortDescription())
								 .createdOn(postDto.getCreatedOn())
								 .updatedOn(postDto.getUpdatedOn())
								 .build();
		
		return post;
	}
}
