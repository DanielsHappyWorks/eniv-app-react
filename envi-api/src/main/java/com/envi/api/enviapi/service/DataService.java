package com.envi.api.enviapi.service;

import com.envi.api.enviapi.model.Comments;
import com.envi.api.enviapi.model.Data;
import com.envi.api.enviapi.repository.CommentRepository;
import com.envi.api.enviapi.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    private final DataRepository repository;
    private final CommentRepository commentRepository;

    DataService(DataRepository repository, CommentRepository commentRepository) {
        this.repository = repository;
        this.commentRepository = commentRepository;
    }

    public List<Data> findAll() {
        return repository.findAll();
    }

    public Data findById(Long id) {
        return repository.findById(id).orElse( null);
    }

    public Data save(Data course) {
        return repository.save(course);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Comments addComment(Long id, Comments comment) {
        Data data = repository.findById(id).orElse( null);

        if (data == null) {
          return null;
        }

        comment.setData(data);
        return commentRepository.save(comment);
    }
}
