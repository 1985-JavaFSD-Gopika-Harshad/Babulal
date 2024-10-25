package com.demo.controller;

import com.demo.dto.RecipeDTO;
import com.demo.model.Recipe;
import com.demo.model.Review;
import com.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Create a new recipe
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDTO recipeDTO, @RequestParam Long userId, @RequestParam Long categoryId) {
        Recipe createdRecipe = recipeService.save(recipeDTO, userId, categoryId);
        return ResponseEntity.ok(createdRecipe);
    }

    // Get all recipes
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }

    // Get a recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        return ResponseEntity.ok(recipe);
    }

    // Update a recipe
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Recipe updatedRecipe = recipeService.update(id, recipeDTO);
        return ResponseEntity.ok(updatedRecipe);
    }

    // Delete a recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsForRecipe(@PathVariable Long id) {
        List<Review> reviews = recipeService.getReviewsForRecipe(id);
        return ResponseEntity.ok(reviews);
    }

}
