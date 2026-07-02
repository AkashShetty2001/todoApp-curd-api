package com.example.SpringDemoTodo.controllers;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/todos")
@AllArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TodoController {

    private TodoService todoService;

    @GetMapping("/all")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.createTodo(todoDTO);
    }

    @PutMapping("/{id}")
    public Optional<Todo> updateTodo(@PathVariable String id, @RequestBody TodoDTO todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }
}


