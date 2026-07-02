package com.example.SpringDemoTodo.services;

import com.example.SpringDemoTodo.models.Todo;
import com.example.SpringDemoTodo.repositories.ITodoRepository;
import com.example.SpringDemoTodo.repositories.InMemoryListTodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    /*
       we are trying to inject ITodoRepository implementation class bean.
     */
    private ITodoRepository iTodoRepository;

    @Autowired
    public TodoService(@Qualifier("inMemoryListTodoRepository") ITodoRepository iTodoRepository) {
        this.iTodoRepository = iTodoRepository;
    }

    public List<Todo> getAllTodos(){
        return iTodoRepository.getAllTodos();
    }

    public Optional<Todo> getTodoById(@PathVariable String id) {
        return iTodoRepository.getTodoById(id);

    }
}
