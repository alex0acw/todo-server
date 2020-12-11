package com.acw.todoserver.service;

import com.acw.todoserver.entities.Tag;
import com.acw.todoserver.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    Tag getById(String id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isPresent())
            return tag.get();
        else throw new NoSuchElementException();
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
