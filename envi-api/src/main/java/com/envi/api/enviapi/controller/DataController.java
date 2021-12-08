package com.envi.api.enviapi.controller;

import com.envi.api.enviapi.model.Comments;
import com.envi.api.enviapi.model.Data;
import com.envi.api.enviapi.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController()
class DataController {

    private final DataService service;

    DataController(DataService service) {
        this.service = service;
    }

    @GetMapping("/")
    List<Data> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Data getByID(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    Data postCourse(@RequestBody Data course) {
        return service.save(course);
    }

    @PutMapping("/")
    Data putCourse(@RequestBody Data course) {
        return service.save(course);
    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}/comment")
    Comments putComment(@PathVariable Long id, @RequestBody Comments comments) {
        return service.addComment(id, comments);
    }
}