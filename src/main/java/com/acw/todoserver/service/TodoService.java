package com.acw.todoserver.service;

import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getById(String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent())
            return todo.get();
        else
            throw new NoSuchElementException();
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    public Todo updateById(String id, Todo todo) {
        Todo existing = getById(id);
        if (todo.getContent() != null) existing.setContent(todo.getContent());
        if (todo.getTags() != null) existing.setTags(todo.getTags());
        if (todo.getIsDone() != null) existing.setIsDone(todo.getIsDone());
        return todoRepository.save(existing);
    }

    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }
}
