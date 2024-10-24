package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
    Optional<Recipe> findById(Long id);
    
    List<Recipe> findByCuisine(String cuisine);
    List<Recipe> findByMealType(String mealType);

}
