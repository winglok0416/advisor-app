package edu.cuhk.advisor.service;

import edu.cuhk.advisor.dto.kmb.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class KmbInfoService {

    private static final String BASE_URL = "https://data.etabus.gov.hk";

    private ExchangeStrategies listExchangeStrategies = ExchangeStrategies.builder()
            .codecs(configurer -> configurer
            .defaultCodecs()
            .maxInMemorySize(16 * 1024 * 1024))
            .build();

    public Mono<RouteList> getRouteList() {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/route")
                .toString();

        System.out.println(url);

        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(RouteList.class);
    }

    public Mono<Route> getRoute(String route, String direction, String serviceType) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/route")
                .append("/")
                .append(route)
                .append("/")
                .append(direction)
                .append("/")
                .append(serviceType)
                .toString();

        System.out.println(url);

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Route.class);
    }

    public Mono<StopList> getStopList() {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/stop")
                .toString();

        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(StopList.class);
    }

    public Mono<Stop> getStop(String stopId) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/stop")
                .append("/")
                .append(stopId)
                .toString();

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Stop.class);
    }

    public Mono<RouteStopList> getRouteStopList() {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/route-stop")
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(RouteStopList.class);
    }

    public Mono<RouteStop> getRouteStop(String route, String direction, String serviceType) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/route-stop/")
                .append(route)
                .append("/")
                .append(direction)
                .append("/")
                .append(serviceType)
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(RouteStop.class);
    }

    public Mono<ETA> getETA(String stopId, String route, String serviceType) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/eta/")
                .append(stopId)
                .append("/")
                .append(route)
                .append("/")
                .append(serviceType)
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(ETA.class);
    }

    public Mono<StopETA> getStopETA(String stopId) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/v1/transport/kmb/stop-eta/")
                .append(stopId)
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .exchangeStrategies(listExchangeStrategies)
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(StopETA.class);
    }

//    public static ExchangeFilterFunction errorHandler() {
//        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
//            if (clientResponse.statusCode().is5xxServerError()) {
//                return clientResponse.bodyToMono(String.class)
//                        .flatMap(errorBody -> Mono.error(new Http2Exception(errorBody)));
//            } else if (clientResponse.statusCode().is4xxClientError()) {
//                return clientResponse.bodyToMono(String.class)
//                        .flatMap(errorBody -> Mono.error(new UserDefinedException2(errorBody)));
//            } else {
//                return Mono.just(clientResponse);
//            }
//        });
//    }
}

