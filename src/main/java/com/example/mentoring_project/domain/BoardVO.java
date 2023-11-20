package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class BoardVO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String id;
    private Integer hit;

    @Column(length = 2000, nullable = false)
    private String content;

    private String writer;

    @Column(length = 500, nullable = false)
    private String title;

    public void change(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
