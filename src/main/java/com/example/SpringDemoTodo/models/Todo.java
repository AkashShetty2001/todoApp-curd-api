package com.example.SpringDemoTodo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Todo - Entity Model Class
 *
 * Represents a Todo item in the application. This is the core domain model that is stored
 * in the repository and passed between service and repository layers.
 *
 * Lombok annotations are used to automatically generate getters, setters, and constructors.
 */
@Setter
@Getter
@AllArgsConstructor
public class Todo {
    // Unique identifier for the todo item
    private String id;
    // The actual content/description of the todo item
    private String content;

}
