package com.example.Server.service;

import com.example.Server.entity.DocumentEntity;
import com.example.Server.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public DocumentEntity addDocument(DocumentEntity documentEntity){
        return documentRepository.save(documentEntity);
    }
}
