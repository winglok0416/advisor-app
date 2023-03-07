package edu.cuhk.advisor.service;

import edu.cuhk.advisor.dto.spoonacular.AnalyzedResult;
import edu.cuhk.advisor.dto.spoonacular.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Slf4j
@Service
public class SpoonacularApiService {

    private static final String BASE_URL = "https://api.spoonacular.com";

    @Value("${spoonacular.api-key}")
    private String API_KEY;

    private final ExchangeStrategies listExchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(16 * 1024 * 1024))
            .build();

    private WebClient webClient() {
        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(BASE_URL)
                .defaultHeader("x-api-key", API_KEY)
                .build();
    }

    @Cacheable(cacheNames = "spoonacular-recipe-list")
    public Flux<Recipe> getRecipeList(String ingredients, Optional<Integer> number) {
        log.info("Getting recipe list...");
        return webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recipes/findByIngredients")
                        .queryParam("ingredients", ingredients)
                        .queryParam("number", number.orElse(10))
                        .build()
                )
                .retrieve()
                .bodyToFlux(Recipe.class);
    }

    @Cacheable(cacheNames = "spoonacular-analyzed-recipe")
    public Flux<AnalyzedResult> getAnalyzedRecipe(String recipeId, Optional<Boolean> stepBreakdown) {
        log.info("Getting analyzed recipe...");
        return webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/recipes/{recipeId}/analyzedInstructions")
                        .queryParam("stepBreakdown", stepBreakdown.orElse(false))
                        .build(recipeId)
                )
                .retrieve()
                .bodyToFlux(AnalyzedResult.class);
    }
}
