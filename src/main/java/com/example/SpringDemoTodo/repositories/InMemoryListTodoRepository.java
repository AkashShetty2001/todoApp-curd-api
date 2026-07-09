package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.models.Todo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * InMemoryListTodoRepository - Development Profile Repository Implementation
 *
 * This is a simple in-memory repository implementation using ArrayList for storing Todo objects.
 * It is activated when the application runs with the 'dev' profile and is suitable for:
 * - Development and testing environments
 * - Quick prototyping and iteration
 * - Scenarios where data persistence is not required
 *
 * Note: All data is lost when the application restarts. For production use, see InMemoryMapTodoRepository.
 */
@Repository
@Profile("dev")
public class InMemoryListTodoRepository implements ITodoRepository {
    // In-memory list initialized with sample todo data for development
    List<Todo> todos = new ArrayList<>(Arrays.asList(new Todo("1","List")));

    /**
     * Retrieves all todos from the list
     * @return List of all todos
     */
    @Override
    public List<Todo> getAllTodos(){
        return todos;
    }

    /**
     * Finds a todo by its unique identifier
     * @param id the todo's unique identifier
     * @return Optional containing the todo if found, empty otherwise
     */
    @Override
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todos.stream().filter(todo->todo.getId().equals(id)).findFirst();
    }

    /**
     * Adds a new todo to the list
     * @param todo the todo object to create
     * @return the created todo object
     */
    @Override

    public Todo createTodo(Todo todo) {
        todos.add(todo);
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
     * Removes a todo from the list by its identifier
     * @param id the todo's unique identifier
     * @return true if the todo was removed, false if not found
     */
    @Override
    public boolean deleteTodo(String id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}
