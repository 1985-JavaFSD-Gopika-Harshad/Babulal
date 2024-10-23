package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.CommentDTO;  
import com.blog.model.BlogPost;
import com.blog.model.Comment;
import com.blog.repository.BlogPostRepository;
import com.blog.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    public CommentDTO addComment(Long postId, CommentDTO commentDTO) {
        BlogPost blogPost = blogPostRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setAuthorName(commentDTO.getAuthorName());
        comment.setBlogPost(blogPost);
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);
        return convertToDTO(savedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    
    private CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(
            comment.getId(), 
            comment.getContent(), 
            comment.getAuthorName(), 
            comment.getCreatedAt()
        );
    }
}
