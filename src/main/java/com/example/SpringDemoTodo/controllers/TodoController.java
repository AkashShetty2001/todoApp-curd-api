package com.example.SpringDemoTodo.controllers;

import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.repositories.TodoRepository;
import com.example.SpringDemoTodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);

    }


}


