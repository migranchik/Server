package com.example.Server.repository;

import com.example.Server.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentEntity, Long> {
    DocumentEntity findByPath(String path);
}
