package com.example.mentoring_project.dto.qBoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QReplyDTO {
    private Long qRno; // Q&A 게시판의 리플 고유번호
    private Long qBoardNo; // Q&A 게시판의 글 고유번호
    private String qReply; // Q&A 게시판의 리플 내용
    private String nickName; // Q&A 게시판의 리플 작성자 닉네임
    private String id; // Q&A 게시판의 리플 작성자 ID
}
