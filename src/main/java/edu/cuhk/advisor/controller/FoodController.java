package edu.cuhk.advisor.controller;

import edu.cuhk.advisor.dto.Info;
import edu.cuhk.advisor.dto.edamam.RecipeList;
import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.service.EdamamApiService;
import edu.cuhk.advisor.service.NinjaApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final NinjaApiService ninjaApiService;

    private final EdamamApiService edamamApiService;

    public FoodController(NinjaApiService ninjaApiService, EdamamApiService edamamApiService) {
        this.ninjaApiService = ninjaApiService;
        this.edamamApiService = edamamApiService;
    }

    @GetMapping("/nutrition")
    public Flux<Nutrition> getNutritionList(@RequestParam("query") String queryParams) {
        return ninjaApiService.getNutritionList(queryParams);
    }

    @GetMapping("/recipes")
    public Mono<RecipeList> getRecipeList(@RequestParam("query") String query) {
        return edamamApiService.getRecipeList(query);
    }

    @GetMapping("/info")
    public Mono<Info> getFoodInfo(@RequestParam("query") String query) {
        Flux<Nutrition> nutritionList = ninjaApiService.getNutritionList(query);
        Mono<RecipeList> recipeList = edamamApiService.getRecipeList(query);

        return Mono.zip(
                nutritionList.singleOrEmpty(),
                recipeList,
                Info::new
        );
    }
}
