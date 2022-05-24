package com.example.Server.repository;

import com.example.Server.entity.CountFilesEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountFilesRepository extends CrudRepository<CountFilesEntity, Long> {
}
