package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QBoardVO {
    private Long qBoardNo;
    private String id;
    private Integer hit;
    private String nickName;
    private String content;
    private String title;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

}
