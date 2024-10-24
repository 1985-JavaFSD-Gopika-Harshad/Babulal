package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.RecipeDTO;
import com.demo.model.Recipe;
import com.demo.repository.RecipeRepository;
import com.demo.exception.RecipeNotFoundException;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    
    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        // Map DTO fields to Recipe fields
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

    public Recipe updateRecipe(Long id, RecipeDTO recipeDTO) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            // Update recipe fields
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
        throw new RecipeNotFoundException("Recipe with ID " + id + " not found.");
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe with ID " + id + " not found."));
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    public List<Recipe> getRecipesByCuisine(String cuisine) {
        return recipeRepository.findByCuisine(cuisine);
    }
    
    public List<Recipe> getRecipesByMealType(String mealType) {
        return recipeRepository.findByMealType(mealType);
    }
}
