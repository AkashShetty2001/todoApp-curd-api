package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.models.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoRepository {
    /*
      get All todo
     */
    List<Todo> getAllTodos();

    /*
        get a tody by id.
     */
    Optional<Todo> getTodoById(String id);
}
