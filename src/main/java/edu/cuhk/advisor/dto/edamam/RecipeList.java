package edu.cuhk.advisor.dto.edamam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeList {
    private Integer from;
    private Integer to;
    private Integer count;
    private Set<Hit> hits;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Hit {
    private Recipe recipe;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Recipe {
    private String uri;
    private String label;
    private String image;
    private Map<String, ImageMetadata> images;
    private String source;
    private String url;
    private String shareAs;
    private Float yield;
    private Set<String> dietLabels;
    private Set<String> healthLabels;
    private Set<String> cautions;
    private Set<String> ingredientLines;
    private Set<Ingredient> ingredients;
    private Double calories;
    private Double totalWeight;
    private Integer totalTime;
    private Set<String> cuisineType;
    private Set<String> mealType;
    private Set<String> dishType;
    private Map<String, Nutrient> totalNutrients;
    private Set<Digest> digest;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Digest {
    private String label;
    private String tag;
    private String schemaOrgTag;
    private Double total;
    private Boolean hasRDI;
    private Double daily;
    private String unit;
    private Set<Digest> sub;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class ImageMetadata {
    private String url;
    private String width;
    private String height;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Ingredient {
    private String text;
    private Integer quantity;
    private String measure;
    private String food;
    private Integer weight;
    private String foodCategory;
    private String foodId;
    private String image;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Nutrient {
    private String label;
    private Double quantity;
    private String unit;
}