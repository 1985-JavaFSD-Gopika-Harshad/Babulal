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
public class CommentDTO {
	private Long id;
    private String content;
    private String authorName;
    private LocalDateTime createdAt;
}
