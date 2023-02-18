package edu.cuhk.advisor.controller;

import edu.cuhk.advisor.dto.ninja.Info;
import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.dto.ninja.Recipe;
import edu.cuhk.advisor.service.NinjaApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaApiService ninjaApiService;

    public NinjaController(NinjaApiService ninjaApiService) {
        this.ninjaApiService = ninjaApiService;
    }

    @GetMapping("/nutrition")
    public Flux<Nutrition> getNutritionList(@RequestParam("query") String queryParams) {
        return ninjaApiService.getNutritionList(queryParams);
    }

    @GetMapping("/recipe")
    public Flux<Recipe> getRecipeList(@RequestParam("query") String queryParams, @RequestParam(name = "offset", required = false) Optional<String> offset) {
        return ninjaApiService.getRecipeList(queryParams, offset);
    }

    @GetMapping("/food-info")
    public Mono<Info> getFoodInfo(@RequestParam("query") String queryParams, @RequestParam(name = "offset", required = false) Optional<String> offset) {
        return ninjaApiService.getFoodInfo(queryParams, offset);
    }
}
