package com.demo.controller;

import com.demo.dto.RecipeDTO;
import com.demo.model.Recipe;
import com.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe createdRecipe = recipeService.createRecipe(recipeDTO);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDTO);
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<Recipe>> getRecipesByCuisine(@PathVariable String cuisine) {
        List<Recipe> recipes = recipeService.getRecipesByCuisine(cuisine);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/mealType/{mealType}")
    public ResponseEntity<List<Recipe>> getRecipesByMealType(@PathVariable String mealType) {
        List<Recipe> recipes = recipeService.getRecipesByMealType(mealType);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
