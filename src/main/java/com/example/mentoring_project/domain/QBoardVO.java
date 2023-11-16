package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class QBoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qBoardNo;


    private String id;
    private Integer hit;
    private String nickName;

    @Column(length = 5000, nullable = false)
    private String content;

    @Column(length = 15, nullable = false)
    private String title;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

}
