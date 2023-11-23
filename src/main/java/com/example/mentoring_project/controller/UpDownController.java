package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.upload.UploadFileDTO;
import com.example.mentoring_project.dto.upload.UploadResultDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@Log4j2
public class UpDownController {
    @Value("${com.example.upload.path}")
    private String uploadPath;

    @ApiOperation(value = "Upload Post", notes = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(UploadFileDTO uploadFileDTO){
        log.info(uploadFileDTO);
        if(uploadFileDTO.getFiles() != null){
            List<UploadResultDTO> list = new ArrayList<>(); //upload()는 List<UploadResultDTO>를 반환하도록 수정
            for (MultipartFile multipartFile : uploadFileDTO.getFiles()){
                String originalName = multipartFile.getOriginalFilename();
                log.info(multipartFile.getOriginalFilename());

                String uuid = UUID.randomUUID().toString();

                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);
                boolean isImage = true;
                try {
                    multipartFile.transferTo(savePath); //실제 파일 저장

                    //이미지 파일이면 섬네일 생성
                    if (Files.probeContentType(savePath).startsWith("image")){
                        log.info(Files.probeContentType(savePath));
                        isImage = true;
                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .isImage(isImage)
                        .build());
            }
            return list;
        }
        return null;
    }

    //viewFileGet() 메서드를 추가
    @ApiOperation(value = "view 파일", notes = "GET방식으로 첨부파일 조회")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGet(@PathVariable String fileName){
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        } catch (IOException e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @ApiOperation(value = "remove 파일", notes = "DELETE 방식으로 파일 삭제")
    @DeleteMapping("/remove/{fileName}")
    public Map<String, Boolean> removeFile(@PathVariable String fileName){
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
        String resourceName = resource.getFilename();

        Map<String, Boolean> resultMap = new HashMap<>();
        boolean remove = true;
        try{
            String contentType = Files.probeContentType(resource.getFile().toPath());
            remove = resource.getFile().delete();

            //섬네일이 존재한다면
            if (contentType.startsWith("image")){
                File thumbFile = new File(uploadPath + File.separator + "s_" + fileName);
                thumbFile.delete();
            }
        } catch (IOException e){
            log.error(e.getMessage());
        }
        resultMap.put("result", remove);
        return resultMap;
    }




}
