package com.example.mentoring_project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
