package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.BlogPost;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
	List<BlogPost> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String titleKeyword, String contentKeyword);
}
