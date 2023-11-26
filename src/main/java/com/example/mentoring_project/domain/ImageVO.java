package com.example.mentoring_project.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
    private String uuid;
    private String fileNames;
    private int ord;
    private int boardNo;
}
