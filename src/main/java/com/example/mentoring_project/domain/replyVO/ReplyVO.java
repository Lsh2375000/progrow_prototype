package com.example.mentoring_project.domain.replyVO;

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
    private String content; //리플의 내용
    private String nickname; //리플 작성자
    private Long boardNo; //게시판의 글 고유번호

    public void changeText(String content){ //댓글 수정
        this.content = content;
    }
}
