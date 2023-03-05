package edu.cuhk.advisor.service;

import edu.cuhk.advisor.dto.edamam.RecipeList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class EdamamApiService {

    private static final String BASE_URL = "https://api.edamam.com";

    @Value("${edamam.app-id}")
    private String APP_ID;
    @Value("${edamam.app-key}")
    private String APP_KEY;

    private final ExchangeStrategies listExchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(16 * 1024 * 1024))
            .build();

    private WebClient webClient() {
        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(BASE_URL)
                .build();
    }

    @Cacheable(cacheNames = "recipe-list")
    public Mono<RecipeList> getRecipeList(String queryParams) {
        log.info("Getting recipe list...");
        return webClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/recipes/v2")
                        .queryParam("app_id", APP_ID)
                        .queryParam("app_key", APP_KEY)
                        .queryParam("type", "public")
                        .queryParam("q", queryParams)
                        .build()
                )
                .retrieve()
                .bodyToMono(RecipeList.class);
    }
}
