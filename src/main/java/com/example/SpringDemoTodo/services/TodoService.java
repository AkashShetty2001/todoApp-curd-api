package com.example.SpringDemoTodo.services;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.repositories.ITodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TodoService - Business Logic Layer (Service Layer)
 *
 * This service contains the core business logic for todo operations.
 * It acts as an intermediary between the Controller and Repository layers.
 * The service layer is responsible for:
 * - Implementing business rules and validations
 * - Processing data transformations (DTOs to Models)
 * - Orchestrating complex operations
 * - Delegating data persistence to the Repository layer
 *
 * Dependencies:
 * - ITodoRepository: Interface for data access operations
 */
@Service
@AllArgsConstructor
public class TodoService {

    // Repository interface for data persistence operations
    private ITodoRepository iTodoRepository;

    /**
     * Retrieves all todos from the repository
     *
     * @return List of all Todo objects stored in the repository
     */
    public List<Todo> getAllTodos(){
        return iTodoRepository.getAllTodos();
    }

    /**
     * Retrieves a specific todo by its ID
     *
     * @param id the unique identifier of the todo to retrieve
     * @return Optional containing the Todo if found, empty Optional if not found
     */
    public Optional<Todo> getTodoById(String id) {
        return iTodoRepository.getTodoById(id);
    }

    /**
     * Creates a new todo with auto-generated ID
     *
     * Business Logic:
     * - Finds the highest existing ID number
     * - Generates a new ID by incrementing the highest ID
     * - Creates a new Todo object with the generated ID and provided content
     * - Persists the new todo in the repository
     *
     * @param todoDTO Data Transfer Object containing the todo content
     * @return the newly created Todo object with auto-generated ID
     */
    public Todo createTodo(TodoDTO todoDTO) {
        // Generate a unique ID by finding the max existing ID and incrementing it
        // Using streams for more functional approach (modern Java)
        int lastId = iTodoRepository.getAllTodos().stream()
                .mapToInt(todo -> Integer.parseInt(todo.getId()))
                .max()
                .orElse(0); // If no todos exist, start with ID 0

        // Create new Todo with generated ID and provided content
        Todo newTodo = new Todo(String.valueOf(lastId + 1), todoDTO.getContent());

        // Persist the new todo in the repository and return it
        return iTodoRepository.createTodo(newTodo);
    }

    /**
     * Updates an existing todo with new content
     *
     * Business Logic:
     * - Creates a new Todo object with the provided ID and updated content
     * - Delegates the update operation to the repository
     * - Returns the updated Todo if found, or empty Optional if not found
     *
     * @param id the unique identifier of the todo to update
     * @param todoDTO Data Transfer Object containing updated todo content
     * @return Optional containing the updated Todo if found, empty Optional if todo doesn't exist
     */
    public Optional<Todo> updateTodo(String id, TodoDTO todoDTO) {
        // Create a new Todo object with the existing ID and new content
        Todo todo = new Todo(id, todoDTO.getContent());

        // Update the todo in repository and return the result
        return iTodoRepository.updateTodo(id, todo);
    }

    /**
     * Deletes a todo by its ID
     *
     * @param id the unique identifier of the todo to delete
     * @return true if the todo was successfully deleted, false if todo was not found
     */
    public boolean deleteTodo(String id) {
        return iTodoRepository.deleteTodo(id);
    }
}
