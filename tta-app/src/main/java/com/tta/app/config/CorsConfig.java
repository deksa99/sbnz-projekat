package com.tta.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String vuePath = "http://localhost:8080";
        registry.addMapping("/**")
                .allowedOrigins(vuePath, "*")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS", "PATCH");
    }
}
