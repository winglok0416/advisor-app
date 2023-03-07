package edu.cuhk.advisor.dto.spoonacular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzedResult {
    private String name;
    private List<Step> steps;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Step {
    private Integer number;
    private String step;
    private Set<Attribute> ingredients;
    private Set<Attribute> equipment;
    private Length length;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Attribute {
    private Long id;
    private String name;
    private String localizedName;
    private String image;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Length {
    private Integer number;
    private String unit;
}