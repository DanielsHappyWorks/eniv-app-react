package com.envi.api.enviapi.repository;

import com.envi.api.enviapi.model.Comments;
import com.envi.api.enviapi.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    Comments findById(long id);
}