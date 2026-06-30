package com.example.SpringDemoTodo.services;

import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.getAllTodos();
    }

    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todoRepository.getTodoById(id);

    }
}
