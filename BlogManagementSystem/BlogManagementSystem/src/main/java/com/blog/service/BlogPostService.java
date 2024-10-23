package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.BlogPostDTO; 
import com.blog.dto.CommentDTO;
import com.blog.model.BlogPost;
import com.blog.repository.BlogPostRepository;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPostDTO createPost(BlogPostDTO blogPostDTO) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(blogPostDTO.getTitle());
        blogPost.setContent(blogPostDTO.getContent());
        blogPost.setCreatedAt(LocalDateTime.now());

        BlogPost savedPost = blogPostRepository.save(blogPost);
        return convertToDTO(savedPost);
    }

    public List<BlogPostDTO> getAllPosts() {
        return blogPostRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BlogPostDTO updatePost(Long id, BlogPostDTO blogPostDTO) {
        BlogPost existingPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + id));

        existingPost.setTitle(blogPostDTO.getTitle());
        existingPost.setContent(blogPostDTO.getContent());

        BlogPost updatedPost = blogPostRepository.save(existingPost);
        return convertToDTO(updatedPost);
    }

    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public List<BlogPostDTO> searchPosts(String keyword) {
        return blogPostRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BlogPostDTO getPostById(Long id) {
        BlogPost post = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with ID: " + id));
        return convertToDTO(post);
    }

    private BlogPostDTO convertToDTO(BlogPost blogPost) {
        List<CommentDTO> commentDTOs = blogPost.getComments().stream()
                .map(comment -> new CommentDTO(comment.getId(), comment.getContent(), comment.getAuthorName(), comment.getCreatedAt()))
                .collect(Collectors.toList());
                
        return new BlogPostDTO(blogPost.getId(), blogPost.getTitle(), blogPost.getContent(), blogPost.getCreatedAt(), commentDTOs);
    }
}
