package edu.cuhk.advisor.dto.ninja;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Nutrition {

    private String name;

    private Float calories;

    @JsonProperty("serving_size_g")
    private Float servingSize;

    @JsonProperty("fat_total_g")
    private Float totalFat;

    @JsonProperty("fat_saturated_g")
    private Float saturatedFat;

    @JsonProperty("protein_g")
    private Float protein;

    @JsonProperty("sodium_mg")
    private Float sodium;

    @JsonProperty("potassium_mg")
    private Float potassium;

    @JsonProperty("cholesterol_mg")
    private Float cholesterol;

    @JsonProperty("carbohydrates_total_g")
    private Float totalCarbohydrates;

    @JsonProperty("fiber_g")
    private Float fiber;

    @JsonProperty("sugar_g")
    private Float sugar;
}
