package com.example.mentoring_project.domain.qBoardVO;

import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QReplyVO {
    private Long qnaRno; //리플 고유 번호
    private Long qnaBoardNo; //게시판의 글 고유번호
    private String content; //리플의 내용
    private String nickName; //리플 작성자 닉네임
    private String id; //리플 작성자 아이디
    private int qReplyCount; // 리플 수 카운트

    public void changeQnaText(String content){
        this.content = content;
    }
}