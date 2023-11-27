package com.example.mentoring_project.dto.boardDTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Integer boardNo;
    private String id;
    private String nickName;
    private String title;
    private String content;
    private Integer hit;
    private LocalDateTime addDate;
    private String fileNames;
}
