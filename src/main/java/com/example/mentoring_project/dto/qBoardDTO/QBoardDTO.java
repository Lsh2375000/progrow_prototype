package com.example.mentoring_project.dto.qBoardDTO;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QBoardDTO {
    private Long qBoardNo;
    private String id;
    private Integer hit;
    private String nickName;
    private String content;
    private String title;


}
