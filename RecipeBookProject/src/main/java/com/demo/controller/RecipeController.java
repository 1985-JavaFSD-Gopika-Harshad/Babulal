package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dto.RecipeDTO;
import com.demo.model.Category;
import com.demo.model.Recipe;
import com.demo.model.Review;
import com.demo.service.CategoryService;
import com.demo.service.RecipeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private CategoryService categoryService;

    // Create a new recipe
    @PostMapping("/create")
    public ResponseEntity<Recipe> createRecipe(@RequestParam Long categoryId, RecipeDTO recipeDTO, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId"); // Ensure you set the user ID in session during login
        recipeDTO.setUserId(userId);
        recipeDTO.setCategoryId(categoryId); // Set the category ID

        Recipe createdRecipe = recipeService.save(recipeDTO, userId, categoryId);
        return ResponseEntity.ok(createdRecipe);
    }
    
    // Get all recipes
    @GetMapping("/all")
    public ModelAndView showAllRecipes() {
        List<Recipe> recipes = recipeService.findAll();
        List<Category> categories = categoryService.findAll(); // Assuming you have a CategoryService to fetch categories
        
        ModelAndView modelAndView = new ModelAndView("home2");
        modelAndView.addObject("recipes", recipes);
        modelAndView.addObject("categories", categories); // Add categories to the model
        
        return modelAndView; // Return the ModelAndView
    }
    
    // Get a recipe by ID
    @GetMapping("/{id}")
    public ModelAndView getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("recipeDetails"); // Change this to your JSP file for recipe details
        modelAndView.addObject("recipe", recipe);
        return modelAndView;
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
    
    @GetMapping("/addRecipe")
    public ModelAndView showAddRecipeForm(Model model) {
        List<Category> categories = categoryService.findAll(); // Fetch categories
        model.addAttribute("categories", categories); // Add categories to the model
        return new ModelAndView("addRecipe"); // Name of your JSP file without the .jsp extension
    }
    
    @GetMapping("/category/{id}")
    public ModelAndView showRecipesByCategory(@PathVariable Long id) {
        List<Recipe> recipes = recipeService.findById(id); // Implement this in your service
        ModelAndView modelAndView = new ModelAndView("categoryRecipes"); // Create a new JSP for category recipes
        modelAndView.addObject("recipes", recipes);
        modelAndView.addObject("categoryId", id);
        return modelAndView;
    }

}
