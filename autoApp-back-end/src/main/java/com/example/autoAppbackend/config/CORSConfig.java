package com.example.autoAppbackend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "https://localhost:8080/swagger/**", "https://localhost:8081/swagger/**")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
        .allowedHeaders("Authorization", "Content-Type", "Accept")
        .allowCredentials(false);

        
    }

    
}

