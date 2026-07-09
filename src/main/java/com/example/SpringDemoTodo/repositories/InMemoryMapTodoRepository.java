package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.models.Todo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * InMemoryMapTodoRepository - Production Profile Repository Implementation
 *
 * This is an in-memory repository implementation using HashMap for storing Todo objects.
 * It is activated when the application runs with the 'prod' profile and is suitable for:
 * - Production environments with in-memory data storage
 * - Scenarios requiring faster O(1) lookup times compared to list-based searches
 * - Applications where data persistence via database is not immediately required
 *
 * Note: All data is lost when the application restarts. For true persistence, integrate a real database.
 */
@Repository
@Profile("prod")
public class InMemoryMapTodoRepository implements ITodoRepository {

    // In-memory map for O(1) todo lookups by ID, initialized with sample data
    Map<String, Todo> todos = new HashMap<>(
            Map.of("1", new Todo("1", "Map"))
    );

    /**
     * Retrieves all todos by converting the map values to a list
     * @return List containing all todos from the map
     */
    @Override
    public List<Todo> getAllTodos() {
        return new ArrayList<Todo>(todos.values());
    }

    /**
     * Finds a todo by its unique identifier with O(1) complexity
     * @param id the todo's unique identifier
     * @return Optional containing the todo if found, empty otherwise
     */
    @Override
    public Optional<Todo> getTodoById(String id) {
        return Optional.ofNullable(todos.get(id));
    }

    /**
     * Adds a new todo to the map
     * @param todo the todo object to create
     * @return the created todo object
     */
    @Override
    public Todo createTodo(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }

    /**
     * Updates an existing todo's content
     * @param id the todo's unique identifier
     * @param todo the todo object containing updated information
     * @return Optional containing the updated todo if found, empty otherwise
     */
    @Override
    public Optional<Todo> updateTodo(String id, Todo todo) {
        return getTodoById(id).map(existing -> {
            existing.setContent(todo.getContent());
            return existing;
        });
    }

    /**
     * Removes a todo from the map by its identifier
     * @param id the todo's unique identifier
     * @return true if the todo was removed, false if not found
     */
    @Override
    public boolean deleteTodo(String id) {
        return todos.remove(id) != null;
    }
}
