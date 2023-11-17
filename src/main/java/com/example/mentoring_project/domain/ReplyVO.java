package com.example.mentoring_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ReplyVO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno; //리플 고유 번호
    @ManyToOne(fetch = FetchType.LAZY)
    private Long boardNo; //게시판의 글 고유번호
    private String replyText; //리플의 내용
    private String replyWriter; //리플 작성자

    public void changeText(String text){
        this.replyText = text;
    }
}
