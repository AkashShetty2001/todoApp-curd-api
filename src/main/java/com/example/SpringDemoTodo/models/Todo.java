package com.example.SpringDemoTodo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
public class Todo {
    private String id;
    private String content;

}
