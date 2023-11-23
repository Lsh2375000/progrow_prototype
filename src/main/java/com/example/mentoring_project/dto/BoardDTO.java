package com.example.mentoring_project.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

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

    @NotEmpty
    private String content;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String title;

    @NotEmpty
    private String writer;

    //첨부파일의 이름들
    private List<String> fileNames;


}
