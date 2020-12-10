package com.acw.todoserver;


import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.repositories.TagRepository;
import com.acw.todoserver.repositories.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TagRepository tagRepository;

    @AfterEach
    @BeforeEach
    void tearDown() {
        todoRepository.deleteAll();
        tagRepository.deleteAll();
    }

    @Test
    void should_return_all_todos_when_get_todos() throws Exception {
        //given
        List<Todo> todos = List.of(
                new Todo(null, "todo1", List.of("tag1")),
                new Todo(null, "todo2", List.of("tag1")));
        todoRepository.saveAll(todos);
        //when
        //then
        mockMvc.perform(get("/todos")).
                andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect(jsonPath("$[0].content").value("todo1"))
                .andExpect(jsonPath("$[0].tags[0]").value("tag1"))
                .andExpect(jsonPath("$[1].id").isString())
                .andExpect(jsonPath("$[1].content").value("todo2"))
                .andExpect(jsonPath("$[1].tags[0]").value("tag1"));
    }

    @Test
    void should_delete_todo_when_delete_todo_given_a_todo() throws Exception {
        //given
        Todo todo = todoRepository.save(new Todo(null, "todo1", List.of("tag1")));
        //when

        //then
        mockMvc.perform(delete("/todos/" + todo.getId()))
                .andExpect(status().isOk());
        assertFalse(todoRepository.findById(todo.getId()).isPresent());
    }

}
