package edu.cuhk.advisor.dto.ninja;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class Info {
    private Nutrition nutrition;
    private List<Recipe> recipes;
}
