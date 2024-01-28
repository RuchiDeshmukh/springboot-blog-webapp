package com.blogwebapp.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
	
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty(message="Email should not be empty")
	private String email;
	@NotEmpty(message="Message should be empty")
	private String content;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	

}
