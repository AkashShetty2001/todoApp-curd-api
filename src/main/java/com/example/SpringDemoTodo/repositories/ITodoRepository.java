package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;

import java.util.List;
import java.util.Optional;

/**
 * ITodoRepository - Data Access Layer Interface (Repository Interface)
 *
 * This interface defines the contract for all data access operations related to Todo entities.
 * It provides an abstraction layer between the Service layer and the actual data storage implementation.
 * The repository pattern allows for:
 * - Decoupling business logic from data access logic
 * - Easy switching between different storage implementations (e.g., List vs Map vs Database)
 * - Better testability through mock implementations
 * - Centralized data access logic
 *
 * Implementations:
 * - InMemoryListTodoRepository: Uses ArrayList for storing todos (dev profile)
 * - InMemoryMapTodoRepository: Uses HashMap for storing todos (prod profile)
 */
public interface ITodoRepository {

    /**
     * Retrieves all todos from the data store
     *
     * @return List of all Todo objects in the repository
     */
    List<Todo> getAllTodos();

    /**
     * Retrieves a specific todo by its unique identifier
     *
     * @param id the unique identifier of the todo to retrieve
     * @return Optional containing the Todo if found, empty Optional if not found
     */
    Optional<Todo> getTodoById(String id);

    /**
     * Creates and stores a new todo in the data store
     *
     * @param todo the Todo object to be created and stored
     * @return the created Todo object (may include database-generated fields)
     */
    Todo createTodo(Todo todo);

    /**
     * Updates an existing todo in the data store
     *
     * @param id the unique identifier of the todo to update
     * @param todo the Todo object containing updated information
     * @return Optional containing the updated Todo if found, empty Optional if not found
     */
    Optional<Todo> updateTodo(String id, Todo todo);

    /**
     * Deletes a todo from the data store by its unique identifier
     *
     * @param id the unique identifier of the todo to delete
     * @return true if the todo was successfully deleted, false if todo was not found
     */
    boolean deleteTodo(String id);
}
