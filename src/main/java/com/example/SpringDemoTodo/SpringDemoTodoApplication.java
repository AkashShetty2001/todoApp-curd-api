package com.example.SpringDemoTodo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringDemoTodoApplication - Main Application Entry Point
 *
 * This is the main Spring Boot application class that bootstraps the Todo REST API.
 * It enables Spring Boot auto-configuration and component scanning for the application.
 *
 * Responsibilities:
 * 1. Loads environment variables from .env file
 * 2. Injects .env variables into Java system properties
 * 3. Bootstraps the Spring application context
 *
 * The application uses profiles (dev/prod) to switch between different repository implementations.
 */
@SpringBootApplication
public class SpringDemoTodoApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file (ignores if file doesn't exist)
		Dotenv dotenv = Dotenv.configure()
						.ignoreIfMissing()
				        .load();

		// Inject all .env variables into Java's system properties for use throughout the application
		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		// Bootstrap the Spring application and start the embedded Tomcat server
		SpringApplication.run(SpringDemoTodoApplication.class, args);
	}

}
