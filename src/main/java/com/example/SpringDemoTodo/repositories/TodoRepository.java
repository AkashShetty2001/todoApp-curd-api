package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.models.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    List<Todo> todos = new ArrayList<>(Arrays.asList(new Todo("1","work")));

    /*
        * Get all todos, returns the entire List.
     */
    public List<Todo> getAllTodos(){
        return todos;
    }

    /*
        * Get todo by ID, search todo by id, if found return the first find.
     */
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todos.stream().filter(todo->todo.getId().equals(id)).findFirst();


    }
}
