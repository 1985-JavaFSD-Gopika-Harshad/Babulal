package com.demo.service;

import com.demo.dto.ReviewDTO;
import com.demo.model.Review;
import com.demo.model.Recipe;
import com.demo.model.User;
import com.demo.repository.ReviewRepository;
import com.demo.repository.RecipeRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    // Create a new review
    public Review save(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Recipe recipe = recipeRepository.findById(reviewDTO.getRecipeId())
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        Review review = new Review();
        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());
        review.setUser(user);
        review.setRecipe(recipe);

        return reviewRepository.save(review);
    }

    // Get all reviews
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    // Get a review by ID
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    // Update a review
    public Review update(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());

        return reviewRepository.save(review);
    }

    // Delete a review
    public void deleteById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        reviewRepository.delete(review);
    }
}
