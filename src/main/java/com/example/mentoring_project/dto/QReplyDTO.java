package com.example.mentoring_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QReplyDTO {
    private Long qRno; // Q&A 게시판의 리플 고유번호
    private Long qBoardNo; // Q&A 게시판의 글 고유번호
    private String qReplyText; // Q&A 게시판의 리플 내용
    private String qReplyWriter; // Q&A 게시판의 리플 작성자
    private LocalDateTime regDate; // 등록일
    private LocalDateTime modDate; // 수정일
}
