package edu.cuhk.advisor.service;

import edu.cuhk.advisor.dto.ninja.Nutrition;
import edu.cuhk.advisor.dto.ninja.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class NinjaApiService {

    private static final String BASE_URL = "https://api.api-ninjas.com";

    @Value("${ninja.api-key}")
    private String API_KEY;

    public Flux<Nutrition> getNutritionList(String queryParams) {
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
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
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
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
}
