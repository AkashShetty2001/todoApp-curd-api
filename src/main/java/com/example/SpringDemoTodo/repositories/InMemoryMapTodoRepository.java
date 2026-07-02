package com.example.SpringDemoTodo.repositories;

import com.example.SpringDemoTodo.models.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("prod")
public class InMemoryMapTodoRepository implements ITodoRepository {

    Map<String, Todo> todos = new HashMap<>(
            Map.of("2", new Todo("1", "Map"))
    );

    @Override
    public List<Todo> getAllTodos() {
        return new ArrayList<Todo>(todos.values());
    }

    @Override
    public Optional<Todo> getTodoById(String id) {
        return Optional.ofNullable(todos.get(id));
    }
}
