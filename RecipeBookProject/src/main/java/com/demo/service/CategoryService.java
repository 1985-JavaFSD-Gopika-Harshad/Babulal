package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.CategoryDTO;
import com.demo.model.Category;
import com.demo.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    // Create a new category
    public Category save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        // If needed, handle recipe IDs here, depending on your model's relationship

        return categoryRepository.save(category);
    }

    // Get all categories
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Get a category by ID
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Update a category
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        
        category.setName(categoryDTO.getName());
        // If needed, handle recipe IDs here

        return categoryRepository.save(category);
    }

    // Delete a category
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
    }
}
