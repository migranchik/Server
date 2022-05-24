package com.example.Server.service;

import com.example.Server.exception.DocumentAlreadyExistException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileUploadService {

    private final String uploadPath = "C:\\Users\\79996\\IdeaProjects\\Server\\uploads";

    public String uploadFile(MultipartFile file) throws DocumentAlreadyExistException {
        File pathFile = new File(uploadPath);

        if(!pathFile.exists())
            pathFile.mkdir();

        File document = new File(uploadPath + "\\" + file.getOriginalFilename());

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(document)){

            byte[] array = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(array);
                System.out.println(i);
                fileOutputStream.write(array, 0, i);
                if(i < 1024)
                    break;
            }

        } catch (IOException e){
            e.getMessage();
        }

        return "File was uploaded";
    }
}
