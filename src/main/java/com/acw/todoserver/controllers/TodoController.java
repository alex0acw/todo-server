package com.acw.todoserver.controllers;


import com.acw.todoserver.entities.Tag;
import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@ResponseBody
@CrossOrigin
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        todoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Todo updateById(@PathVariable String id, @RequestBody Todo todo) {
        return todoService.updateById(id, todo);
    }


    @PostMapping
    public Todo createTag(@RequestBody Todo todo) {
        return todoService.add(todo);
    }
}
