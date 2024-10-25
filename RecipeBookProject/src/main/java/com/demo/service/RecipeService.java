package com.demo.service;

import com.demo.dto.RecipeDTO;
import com.demo.model.Recipe;
import com.demo.model.Review;
import com.demo.model.User;
import com.demo.model.Category;
import com.demo.repository.RecipeRepository;
import com.demo.repository.UserRepository;
import com.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Create a new recipe
    public Recipe save(RecipeDTO recipeDTO, Long userId, Long categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setCuisine(recipeDTO.getCuisine());
        recipe.setMealType(recipeDTO.getMealType());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setPhotos(recipeDTO.getPhotos());
        recipe.setRating(recipeDTO.getRating());
        recipe.setUser(user);
        recipe.setCategory(category);

        return recipeRepository.save(recipe);
    }

    // Get all recipes
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // Get a recipe by ID
    public Recipe findById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    // Update a recipe
    public Recipe update(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setCuisine(recipeDTO.getCuisine());
        recipe.setMealType(recipeDTO.getMealType());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setInstructions(recipeDTO.getInstructions());
        recipe.setPhotos(recipeDTO.getPhotos());
        recipe.setRating(recipeDTO.getRating());

        return recipeRepository.save(recipe);
    }

    // Delete a recipe
    public void deleteById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        recipeRepository.delete(recipe);
    }
    
 // Add this method to RecipeService
    public List<Review> getReviewsForRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        return recipe.getReviews();
    }

}
