package com.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDTO {
    private Long id;
    private String title;
    private String description;
    private String cuisine;
    private String mealType;
    private List<String> ingredients;
    private String instructions;
    private List<String> photos;
    private double rating;
    private Long userId;       // Link to User
    private Long categoryId;   // Link to Category
}
