package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
	List<BlogPost> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String titleKeyword, String contentKeyword);
}
