package edu.cuhk.advisor.dto.ninja;

import lombok.Data;

@Data
public class Recipe {
    private String title;
    private String ingredients;
    private String servings;
    private String instructions;
}
