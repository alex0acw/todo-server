package com.acw.todoserver.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Todo {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String content;
    private List<String> tags;
    private Boolean isDone;

    public Todo() {
    }

    public Todo(String id, String content, List<String> tags, Boolean isDone) {
        this.id = id;
        this.content = content;
        this.tags = tags;
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    public Boolean getIsDone() {
        return isDone;
    }
}
