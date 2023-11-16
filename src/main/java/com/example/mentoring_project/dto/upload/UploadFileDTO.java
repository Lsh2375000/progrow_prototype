package com.example.mentoring_project.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFileDTO { // 파일 업로드 관련 DTO
    private List<MultipartFile> files;
}
