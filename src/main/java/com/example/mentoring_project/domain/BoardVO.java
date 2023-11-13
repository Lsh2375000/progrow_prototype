package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;


    private String id;
    private Integer hit;
    private String nickName;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 500, nullable = false)
    private String title;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

}
