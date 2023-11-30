package com.example.mentoring_project.domain.qBoardVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;


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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate; // 리플 작성일자

    @JsonIgnore
    private LocalDateTime modDate; // 리플 수정일자

    public void changeQnaText(String content){
        this.content = content;
    }
}