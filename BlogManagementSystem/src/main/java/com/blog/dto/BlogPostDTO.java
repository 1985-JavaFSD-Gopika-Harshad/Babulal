package com.blog.dto;

import java.time.LocalDateTime;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDTO {
	private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentDTO> comments;
}
