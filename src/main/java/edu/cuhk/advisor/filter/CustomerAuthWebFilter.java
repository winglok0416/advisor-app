package edu.cuhk.advisor.filter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

//@Component
public class CustomerAuthWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange,
                             WebFilterChain webFilterChain) {

        if (!serverWebExchange.getRequest().getHeaders().containsKey("X-Auth-Token") ||
                !serverWebExchange.getRequest().getHeaders().get("X-Auth-Token").equals("1234")
        ) {
            serverWebExchange
                    .getResponse()
                    .getHeaders()
                    .add("X-Invalid-Reason", "Missing token");
            serverWebExchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return serverWebExchange.getResponse().writeWith(Mono.empty());
        }

        return webFilterChain.filter(serverWebExchange);
    }
}
