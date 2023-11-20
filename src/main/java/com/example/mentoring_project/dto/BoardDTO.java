package com.example.mentoring_project.dto;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {
    private Long boardNo;
    private String id;
    private Integer hit;
    private String content;
    private String title;
    private String writer;


}
