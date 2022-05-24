package com.example.Server.controller;

import com.example.Server.service.FileUploadService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
public class FileController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping(path = "/upload-document")
    public ResponseEntity uploadDocument(@RequestParam("document") MultipartFile document){
        try {
            return ResponseEntity.ok(fileUploadService.uploadFile(document));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

}
