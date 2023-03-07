package edu.cuhk.advisor.dto;

import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.dto.spoonacular.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Info {
    private Nutrition nutrition;
    private List<Recipe> recipes;
}
