package edu.cuhk.bustrafficindicator.controller;

import edu.cuhk.bustrafficindicator.dto.citybus.*;
import edu.cuhk.bustrafficindicator.service.CitybusInfoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/citybus")
public class CitybusController {

    private CitybusInfoService citybusInfoService;

    public CitybusController(CitybusInfoService citybusInfoService) {
        this.citybusInfoService = citybusInfoService;
    }

    @GetMapping("/company/{companyId}")
    public Mono<Company> getCompanyInfo(@PathVariable("companyId") String companyId) {
        return citybusInfoService.getCompany(companyId);
    }

    @GetMapping("/route/{companyId}/{route}")
    public Mono<Route> getRouteInfo(@PathVariable("companyId") String companyId, @PathVariable("route") String route) {
        return citybusInfoService.getRoute(companyId, route);
    }

    @GetMapping("/route/{companyId}")
    public Mono<RouteList> getRouteInfo(@PathVariable("companyId") String companyId) {
        return citybusInfoService.getRouteList(companyId);
    }

    @GetMapping("/stop/{stopId}")
    public Mono<Stop> getStopInfo(@PathVariable("stopId") String stopId) {
        return citybusInfoService.getBusStop(stopId);
    }

    @GetMapping("/route-stop/{companyId}/{route}/{direction}")
    public Mono<RouteStop> getStopInfo(@PathVariable("companyId") String companyId, @PathVariable("route") String route, @PathVariable("direction") String direction) {
        return citybusInfoService.getRouteStop(companyId, route, direction);
    }

    @GetMapping("/eta/{companyId}/{stopId}/{route}")
    public Mono<ETA> getBusETAInfo(@PathVariable("companyId") String companyId, @PathVariable("stopId") String stopId, @PathVariable("route") String route) {
        return citybusInfoService.getETA(companyId, stopId, route);
    }

}
