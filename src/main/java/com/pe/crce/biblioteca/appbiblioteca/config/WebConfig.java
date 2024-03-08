package com.pe.crce.biblioteca.appbiblioteca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.mapping}")
    private String MAPPING;

    @Value("${cors.allowed-origins}")
    private String[] ORIGINS;

    @Value("${cors.allowed-methods}")
    private String[] METHODS;

    @Value("${cors.allowed-head}")
    private String[] HEADS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(MAPPING)
                .allowedOrigins(ORIGINS)
                .allowedMethods(METHODS)
                .allowedHeaders(HEADS)
                .maxAge(360000)
                .allowCredentials(false);
    }

}
