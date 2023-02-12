package edu.cuhk.bustrafficindicator.controller;

import edu.cuhk.bustrafficindicator.dto.kmb.*;
import edu.cuhk.bustrafficindicator.service.KmbInfoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/kmb")
public class KmbController {

    private KmbInfoService kmbInfoService;

    public KmbController(KmbInfoService kmbInfoService) {
        this.kmbInfoService = kmbInfoService;
    }

    @GetMapping("/route")
    public Mono<RouteList> getRouteList() {
        return kmbInfoService.getRouteList();
    }

    @GetMapping("/route/{route}/{direction}/{serviceType}")
    public Mono<Route> getRouteInfo(@PathVariable("route") String route, @PathVariable("direction") String direction, @PathVariable("serviceType") String serviceType) {
        return kmbInfoService.getRoute(route, direction, serviceType);
    }

    @GetMapping("/stop")
    public Mono<StopList> getStopList() {
        return kmbInfoService.getStopList();
    }

    @GetMapping("/stop/{stopId}")
    public Mono<Stop> getStop(@PathVariable("stopId") String stopId) {
        return kmbInfoService.getStop(stopId);
    }

    @GetMapping("/route-stop")
    public Mono<RouteStopList> getRouteStopList() {
        return kmbInfoService.getRouteStopList();
    }

    @GetMapping("/route-stop/{route}/{direction}/{serviceType}")
    public Mono<RouteStop> getRouteStop(@PathVariable("route") String route, @PathVariable("direction") String direction, @PathVariable("serviceType") String serviceType) {
        return kmbInfoService.getRouteStop(route, direction, serviceType);
    }

    @GetMapping("/eta/{stopId}/{route}/{serviceType}")
    public Mono<ETA> getETA(@PathVariable("stopId") String stopId, @PathVariable("route") String route, @PathVariable("serviceType") String serviceType) {
        return kmbInfoService.getETA(stopId, route, serviceType);
    }

    @GetMapping("/stop-eta/{stopId}")
    public Mono<StopETA> geStopETA(@PathVariable("stopId") String stopId) {
        return kmbInfoService.getStopETA(stopId);
    }


//    @GetMapping("/company/{companyId}")
//    public Mono<Company> getCompanyInfo(@PathVariable("companyId") String companyId) {
//        return citybusInfoService.getCompanyInfo(companyId);
//    }
//
//    @GetMapping(path = {"/route/{companyId}", "/route/{companyId}/{route}"})
//    public Mono<Route> getRouteInfo(@PathVariable("companyId") String companyId, @PathVariable(name ="route", required = false) Optional<String> route) {
//        return citybusInfoService.getBusRoute(companyId, route);
//    }
//
//    @GetMapping("/stop/{stopId}")
//    public Mono<Stop> getStopInfo(@PathVariable("stopId") String stopId) {
//        return citybusInfoService.getBusStop(stopId);
//    }
//
//    @GetMapping("/route-stop/{companyId}/{route}/{direction}")
//    public Mono<RouteStop> getStopInfo(@PathVariable("companyId") String companyId, @PathVariable("route") String route, @PathVariable("direction") String direction) {
//        return citybusInfoService.getBusRouteStop(companyId, route, direction);
//    }
//
//    @GetMapping("/eta/{companyId}/{stopId}/{route}")
//    public Mono<ETA> getBusETAInfo(@PathVariable("companyId") String companyId, @PathVariable("stopId") String stopId, @PathVariable("route") String route) {
//        return citybusInfoService.getBusETA(companyId, stopId, route);
//    }

}
