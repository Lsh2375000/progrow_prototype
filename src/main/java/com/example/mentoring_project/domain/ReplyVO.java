package com.example.mentoring_project.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyVO{

    private Long rno; //리플 고유 번호

    @NotNull
    private Long boardNo; //게시판의 글 고유번호

    @NotEmpty
    private String replyText; //리플의 내용

    @NotEmpty
    private String replyWriter; //리플 작성자

    public void changeText(String text){ //댓글 수정
        this.replyText = text;
    }
}
