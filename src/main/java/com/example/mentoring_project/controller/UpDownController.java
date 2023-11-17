package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.upload.UploadFileDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {
    @Value("${com.example.upload.path}")
    private String uploadPath;

    @ApiOperation(value = "Upload Post", notes = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(UploadFileDTO uploadFileDTO){
        log.info(uploadFileDTO);
        if(uploadFileDTO.getFiles() != null){
            for (MultipartFile multipartFile : uploadFileDTO.getFiles()){
                String originalName = multipartFile.getOriginalFilename();
                log.info(multipartFile.getOriginalFilename());
                String uuid = UUID.randomUUID().toString();

                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);
                try {
                    multipartFile.transferTo(savePath); //실제 파일 저장
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

//    @ApiOperation(value = "Upload Post", notes = "POST 방식으로 파일 등록")

}