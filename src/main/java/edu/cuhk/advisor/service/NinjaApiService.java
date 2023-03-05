package edu.cuhk.advisor.service;

import edu.cuhk.advisor.dto.ninja.Info;
import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.dto.ninja.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
public class NinjaApiService {

    private static final String BASE_URL = "https://api.api-ninjas.com";

    @Value("${ninja.api-key}")
    private String API_KEY;

    private WebClient webClient() {
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    @Cacheable(cacheNames = "nutrition-list")
    public Flux<Nutrition> getNutritionList(String queryParams) {
        log.info("Getting nutrition list...");
        return webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/nutrition")
                        .queryParam("query", queryParams)
                        .build()
                )
                .header("X-Api-Key", API_KEY)
                .retrieve()
                .bodyToFlux(Nutrition.class);
    }

    public Flux<Recipe> getRecipeList(String queryParams, Optional<String> offset) {
        log.info("Getting recipe list...");
        return webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/recipe")
                        .queryParam("query", queryParams)
                        .queryParamIfPresent("offset", offset)
                        .build()
                )
                .header("X-Api-Key", API_KEY)
                .retrieve()
                .bodyToFlux(Recipe.class);
    }

    public Mono<Info> getFoodInfo(String queryParams, Optional<String> offset) {
        Flux<Nutrition> nutritionList = getNutritionList(queryParams);
        Flux<Recipe> recipeList = getRecipeList(queryParams, offset);

        return Mono.zip(
                nutritionList.singleOrEmpty(),
                recipeList.map(a -> a).collectList(),
                Info::new
        );
    }
}
