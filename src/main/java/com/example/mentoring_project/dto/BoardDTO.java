package com.example.mentoring_project.dto;

import com.example.mentoring_project.domain.BoardVO;
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
    private String nickName;
    private String content;
    private String title;


}
