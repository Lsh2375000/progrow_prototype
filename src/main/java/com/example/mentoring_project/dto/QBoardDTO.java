package com.example.mentoring_project.dto;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QBoardDTO {
    private Long QboardNo;
    private String id;
    private Integer hit;
    private String nickName;
    private String content;
    private String title;


}
