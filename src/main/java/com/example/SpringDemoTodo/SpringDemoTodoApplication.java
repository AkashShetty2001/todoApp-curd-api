package com.example.SpringDemoTodo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoTodoApplication {

	public static void main(String[] args) {

		//before running the application load configure env files.
		Dotenv dotenv = Dotenv.configure()
						.ignoreIfMissing()
				        .load();

		// 2. Loop through the .env variables and inject them into Java's System Environment
		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(SpringDemoTodoApplication.class, args);
	}

}
