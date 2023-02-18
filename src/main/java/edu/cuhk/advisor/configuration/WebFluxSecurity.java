package edu.cuhk.advisor.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Slf4j
@EnableWebFluxSecurity
public class WebFluxSecurity {
    @Bean
    public SecurityWebFilterChain chain(ServerHttpSecurity http){
        return http
                .httpBasic().disable()	//No Http Basic Login
                .csrf().disable()	//No CSRF token
                .formLogin().disable()	//No Form Login
                .logout().disable()	//No Logout
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .build();
    }
}