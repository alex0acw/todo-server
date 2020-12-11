package com.acw.todoserver.controllers;


import com.acw.todoserver.entities.Tag;
import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@ResponseBody
public class TagController {


    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getAllTodos() {
        return tagService.getAll();
    }

}