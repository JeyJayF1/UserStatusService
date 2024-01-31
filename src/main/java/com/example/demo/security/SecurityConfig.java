package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwks;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    SecurityWebFilterChain configure4Default(ServerHttpSecurity config) throws Exception {

        log.warn("!! configuring security for testing purposes only !!");
        log.info("JWKS: {}", jwks);
        config
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth -> auth.anyExchange().authenticated());

        return config.build();
    }

    private CorsConfigurationSource corsConfig() {
        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedHeaders(List.of("*"));
        cc.setAllowedMethods(List.of("*"));
        cc.setAllowedOrigins(List.of("*"));

        var corsConfig = new UrlBasedCorsConfigurationSource();
        corsConfig.registerCorsConfiguration("/**", cc);

        return corsConfig;
    }


}
