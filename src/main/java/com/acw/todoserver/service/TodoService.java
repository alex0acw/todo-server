package com.acw.todoserver.service;

import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }
}
