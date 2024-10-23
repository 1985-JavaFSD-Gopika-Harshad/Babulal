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

    // Create a new comment
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

    // Read a comment by ID
    public CommentDTO getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return convertToDTO(comment);
    }

    // Read all comments for a specific blog post
    public List<CommentDTO> getCommentsByPostId(Long postId) {
        return commentRepository.findByBlogPostId(postId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Update a comment
    public CommentDTO updateComment(Long commentId, CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        existingComment.setContent(commentDTO.getContent());
        existingComment.setAuthorName(commentDTO.getAuthorName());
        existingComment.setCreatedAt(LocalDateTime.now()); // Assuming you have this field in Comment

        Comment updatedComment = commentRepository.save(existingComment);
        return convertToDTO(updatedComment);
    }

    // Delete a comment
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    // Convert Comment to CommentDTO
    private CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(
            comment.getId(), 
            comment.getContent(), 
            comment.getAuthorName(), 
            comment.getCreatedAt()
        );
    }
}
