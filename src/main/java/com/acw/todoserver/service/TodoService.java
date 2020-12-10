package com.acw.todoserver.service;

import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.repositories.TodoRepository;

import java.util.List;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return null;
    }
}
