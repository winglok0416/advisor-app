package edu.cuhk.advisor.controller;

import edu.cuhk.advisor.dto.Info;
import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.dto.spoonacular.AnalyzedResult;
import edu.cuhk.advisor.dto.spoonacular.Recipe;
import edu.cuhk.advisor.service.EdamamApiService;
import edu.cuhk.advisor.service.NinjaApiService;
import edu.cuhk.advisor.service.SpoonacularApiService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final NinjaApiService ninjaApiService;

    private final EdamamApiService edamamApiService;

    private final SpoonacularApiService spoonacularApiService;

    public FoodController(NinjaApiService ninjaApiService, EdamamApiService edamamApiService, SpoonacularApiService spoonacularApiService) {
        this.ninjaApiService = ninjaApiService;
        this.edamamApiService = edamamApiService;
        this.spoonacularApiService = spoonacularApiService;
    }

    @GetMapping("/nutrition")
    public Flux<Nutrition> getNutritionList(@RequestParam("query") String queryParams) {
        return ninjaApiService.getNutritionList(queryParams);
    }

    @GetMapping("/recipes")
    public Flux<Recipe> getRecipeList(
            @RequestParam("ingredients") String ingredients,
            @RequestParam(value = "number", required = false) Optional<Integer> number
    ) {
        return spoonacularApiService.getRecipeList(ingredients, number);
    }

    @GetMapping("/recipe/{recipeId}")
    public Flux<AnalyzedResult> getRecipe(
            @PathVariable("recipeId") String recipeId,
            @RequestParam(value = "stepBreakdown", required = false) Optional<Boolean> stepBreakdown
    ) {
        return spoonacularApiService.getAnalyzedRecipe(recipeId, stepBreakdown);
    }

    @GetMapping("/info")
    public Mono<Info> getFoodInfo(
            @RequestParam("query") String query,
            @RequestParam(value = "number", required = false) Optional<Integer> number
    ) {
        Flux<Nutrition> nutritionList = ninjaApiService.getNutritionList(query);
        Flux<Recipe> recipeList = spoonacularApiService.getRecipeList(query, number);

        return Mono.zip(
                nutritionList.singleOrEmpty(),
                recipeList.collectList(),
                Info::new
        );
    }
}
