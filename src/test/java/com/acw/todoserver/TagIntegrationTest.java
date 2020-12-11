package com.acw.todoserver;


import com.acw.todoserver.entities.Tag;
import com.acw.todoserver.entities.Todo;
import com.acw.todoserver.repositories.TagRepository;
import com.acw.todoserver.repositories.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TagIntegrationTest {
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
    void should_return_all_tags_when_get_tags() throws Exception {
        //given
        List<Tag> tags = List.of(
                new Tag(null,"tag1","red"),
                new Tag(null,"tag2","black"));
        tagRepository.saveAll(tags);
        //when
        //then
        mockMvc.perform(get("/tags")).
                andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect(jsonPath("$[0].name").value("tag1"))
                .andExpect(jsonPath("$[0].color").value("red"))
                .andExpect(jsonPath("$[1].id").isString())
                .andExpect(jsonPath("$[1].name").value("tag2"))
                .andExpect(jsonPath("$[1].color").value("black"));
    }

//    @Test
//    void should_delete_todo_when_delete_todo_given_a_todo() throws Exception {
//        //given
//        Todo todo = todoRepository.save(new Todo(null, "todo1", List.of("tag1"), true));
//        //when
//
//        //then
//        mockMvc.perform(delete("/todos/" + todo.getId()))
//                .andExpect(status().isOk());
//        assertFalse(todoRepository.findById(todo.getId()).isPresent());
//    }
//
//    @Test
//    void should_return_updated_todd_when_update_todo_given_a_todo() throws Exception {
//        //given
//        Todo todo = new Todo(null, "todo1", List.of("tag1"), true);
//        todo = todoRepository.save(todo);
//        String newTodoAsJson = "{\"content\":\"test\",\"tags\":[\"newTag\",\"newTag2\"],\"isDone\":\"false\"}";
//        //when
//        //then
//        mockMvc.perform(put("/todos/" + todo.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(newTodoAsJson)
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").isString())
//                .andExpect(jsonPath("$.content").value("test"))
//                .andExpect(jsonPath("$.isDone").value(false))
//                .andExpect(jsonPath("$.tags[0]").value("newTag"))
//                .andExpect(jsonPath("$.tags[1]").value("newTag2"));
//
//    }

}
