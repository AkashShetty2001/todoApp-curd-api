package com.example.SpringDemoTodo.controllers;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TodoController - REST API Controller Layer
 *
 * This controller handles all HTTP requests related to Todo operations.
 * It acts as the entry point for client requests and delegates business logic
 * to the TodoService layer. The controller layer is responsible for:
 * - Receiving HTTP requests
 * - Validating request parameters
 * - Calling appropriate service methods
 * - Returning HTTP responses to clients
 *
 * Base URL: /api/v1/todos
 * CORS is enabled to allow cross-origin requests from any source
 */
@RestController
@RequestMapping("api/v1/todos")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TodoController {

    private TodoService todoService;

    /**
     * GET /api/v1/todos/all
     * Retrieves all todos from the database
     *
     * @return List of all Todo objects
     */
    @GetMapping("/all")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    /**
     * GET /api/v1/todos/{id}
     * Retrieves a specific todo by its unique identifier
     *
     * @param id the unique identifier of the todo to retrieve
     * @return Optional containing the Todo if found, empty Optional otherwise
     */
    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }

    /**
     * POST /api/v1/todos
     * Creates a new todo with the provided data
     *
     * @param todoDTO Data Transfer Object containing todo content
     * @return the newly created Todo object with auto-generated id
     */
    @PostMapping
    public Todo createTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.createTodo(todoDTO);
    }

    /**
     * PUT /api/v1/todos/{id}
     * Updates an existing todo with the provided data
     *
     * @param id the unique identifier of the todo to update
     * @param todo TodoDTO containing updated content
     * @return Optional containing the updated Todo if found, empty Optional otherwise
     */
    @PutMapping("/{id}")
    public Optional<Todo> updateTodo(@PathVariable String id, @RequestBody TodoDTO todo) {
        return todoService.updateTodo(id, todo);
    }

    /**
     * DELETE /api/v1/todos/{id}
     * Deletes a todo by its unique identifier
     *
     * @param id the unique identifier of the todo to delete
     * @return true if deletion was successful, false if todo was not found
     */
    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }
}


