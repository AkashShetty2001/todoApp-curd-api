package com.example.SpringDemoTodo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig - Cross-Origin Resource Sharing (CORS) Configuration
 *
 * This configuration class enables CORS for the application to allow requests from different origins.
 * CORS is essential for frontend applications running on different domains/ports to communicate
 * with this backend REST API.
 *
 * Current configuration:
 * - Allows requests to all /api/** endpoints
 * - Permits all HTTP methods (GET, POST, PUT, DELETE, OPTIONS)
 * - Accepts requests from any origin
 * - Cache preflight responses for 3600 seconds (1 hour)
 *
 * Note: The current setup allows all origins ("*") for development. In production, restrict this
 * to specific trusted domains for enhanced security.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings for the application
     * Allows cross-origin requests to API endpoints with specified methods and headers
     *
     * @param registry the CORS registry to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // Allow requests from any origin (use specific URLs in production)
                .allowedOrigins("*")
                // Allow common HTTP methods used in REST APIs
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // Allow all headers in requests
                .allowedHeaders("*")
                // Cache preflight response for 1 hour to reduce CORS checks
                .maxAge(3600);
    }
}
