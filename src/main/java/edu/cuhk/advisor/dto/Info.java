package edu.cuhk.advisor.dto;

import edu.cuhk.advisor.dto.edamam.RecipeList;
import edu.cuhk.advisor.dto.ninja.Nutrition;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Info {
    private Nutrition nutrition;
    private RecipeList recipes;
}
