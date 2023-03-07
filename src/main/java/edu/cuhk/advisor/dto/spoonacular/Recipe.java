package edu.cuhk.advisor.dto.spoonacular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private Long id;
    private String image;
    private String imageType;
    private Long likes;
    private Integer missedIngredientCount;
    private Set<Ingredient> missedIngredients;
    private String title;
    private Set<Ingredient> unusedIngredients;
    private Integer usedIngredientCount;
    private Set<Ingredient> usedIngredients;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Ingredient {
    private String aisle;
    private Float amount;
    private Long id;
    private String image;
    private Set<String> meta;
    private String name;
    private String original;
    private String originalName;
    private String unit;
    private String unitLong;
    private String unitShort;
}
