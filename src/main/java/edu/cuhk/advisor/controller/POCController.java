package edu.cuhk.advisor.controller;

import edu.cuhk.advisor.service.TestProp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/poc")
public class POCController {

    private final TestProp testProp;

    public POCController(TestProp testProp) {
        this.testProp = testProp;
    }

    @GetMapping("/1")
    public Mono<List<String>> testProp() {
        return Mono.just(testProp.getAccounts());
    }
}
