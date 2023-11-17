package com.example.mentoring_project.dto.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {
    private String uuid;
    private String fileName;
    private boolean isImage; // 이미지 파일 여부

    public String getLink() {
        if (isImage) { // 이미지 파일의 경우 섬네일 리턴.
            return "s_" + uuid + "_" + fileName; // 이미지 파일의 경우
        } else {
            return uuid + "_" + fileName;
        }
    }
}
