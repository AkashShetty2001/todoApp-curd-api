package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoRepository {
    List<Todo> getAllTodos();

    Optional<Todo> getTodoById(String id);

    Todo createTodo(Todo todo);

    Optional<Todo> updateTodo(String id, Todo todo);

    boolean deleteTodo(String id);
}
