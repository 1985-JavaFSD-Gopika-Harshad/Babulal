package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.dto.BlogPostDTO; 
import com.blog.service.BlogPostService;

@RestController
@RequestMapping("/blog")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/create")
    public ResponseEntity<BlogPostDTO> createPost(@RequestBody BlogPostDTO blogPostDTO) {
        BlogPostDTO createdPost = blogPostService.createPost(blogPostDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogPostDTO>> getAllPosts() {
        List<BlogPostDTO> posts = blogPostService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BlogPostDTO> updatePost(@PathVariable Long id, @RequestBody BlogPostDTO blogPostDTO) {
        BlogPostDTO updatedPost = blogPostService.updatePost(id, blogPostDTO);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BlogPostDTO>> searchPosts(@RequestParam String keyword) {
        List<BlogPostDTO> posts = blogPostService.searchPosts(keyword);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPostDTO> getPostById(@PathVariable Long id) {
        BlogPostDTO post = blogPostService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
