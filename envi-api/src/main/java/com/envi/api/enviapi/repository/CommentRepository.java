package com.envi.api.enviapi.repository;

import com.envi.api.enviapi.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
    Data findById(long id);
}