package edu.cuhk.bustrafficindicator.service;

import edu.cuhk.bustrafficindicator.dto.citybus.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CitybusInfoService {

    private static final String BASE_URL = "https://rt.data.gov.hk/v1.1";

    public Mono<Company> getCompany(String companyId) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/company/")
                .append(companyId)
                .toString();

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Company.class);
    }

    public Mono<RouteList> getRouteList(String companyId) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/route/")
                .append(companyId)
                .toString();

        System.out.println(url);

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(RouteList.class);
    }

    public Mono<Route> getRoute(String companyId, String route) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/route/")
                .append(companyId)
                .append("/")
                .append(route)
                .toString();

        System.out.println(url);

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Route.class);
    }

    public Mono<Stop> getBusStop(String stopId) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/stop/")
                .append(stopId)
                .toString();

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Stop.class);
    }

    public Mono<RouteStop> getRouteStop(String companyId, String route, String direction) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/route-stop/")
                .append(companyId)
                .append("/")
                .append(route)
                .append("/")
                .append(direction)
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(RouteStop.class);
    }

    public Mono<ETA> getETA(String companyId, String stopId, String route) {
        String url = new StringBuilder()
                .append(BASE_URL)
                .append("/transport/citybus-nwfb/eta/")
                .append(companyId)
                .append("/")
                .append(stopId)
                .append("/")
                .append(route)
                .toString();

        System.out.println(url);
        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(ETA.class);
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

