package com.envi.api.enviapi.service;

import com.envi.api.enviapi.model.Comments;
import com.envi.api.enviapi.model.Data;
import com.envi.api.enviapi.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {
    private final DataRepository repository;

    DataService(DataRepository repository) {
        this.repository = repository;
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

    public Data addComment(Long id, Comments comments) {
        Data data = repository.findById(id).orElse( null);

        if (data == null) {
          return null;
        }

        List<Comments> commentsList = data.getCommentsList();
        commentsList.add(comments);
        data.setCommentsList(commentsList);
        return repository.save(data);
    }
}
