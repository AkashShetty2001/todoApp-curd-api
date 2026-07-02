package com.example.SpringDemoTodo.services;

import com.example.SpringDemoTodo.dtos.TodoDTO;
import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.repositories.ITodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService {

    private ITodoRepository iTodoRepository;

    public List<Todo> getAllTodos(){
        return iTodoRepository.getAllTodos();
    }

    public Optional<Todo> getTodoById(String id) {
        return iTodoRepository.getTodoById(id);
    }

    public Todo createTodo(TodoDTO todoDTO) {

        /*
         int lastId = 0;
    for (Todo todo : iTodoRepository.getAllTodos()) {
        int currentId = Integer.parseInt(todo.getId());
        if (currentId > lastId) {
            lastId = currentId;
        }
    }
    Todo newTodo = new Todo(String.valueOf(lastId + 1), todoDTO.getContent());
    return iTodoRepository.createTodo(newTodo);
         */

        int lastId = iTodoRepository.getAllTodos().stream()
                .mapToInt(todo -> Integer.parseInt(todo.getId()))
                .max()
                .orElse(0);
        Todo newTodo = new Todo(String.valueOf(lastId + 1), todoDTO.getContent());
        return iTodoRepository.createTodo(newTodo);
    }

    public Optional<Todo> updateTodo(String id, TodoDTO todoDTO) {
        Todo todo = new Todo(id, todoDTO.getContent());
        return iTodoRepository.updateTodo(id, todo);
    }

    public boolean deleteTodo(String id) {
        return iTodoRepository.deleteTodo(id);
    }
}
