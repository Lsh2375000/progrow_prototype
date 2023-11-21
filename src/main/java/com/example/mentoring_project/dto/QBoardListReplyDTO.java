package com.example.mentoring_project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QBoardListReplyDTO {
    private Long qBoardNo;
    private String title;
    private String nickName;
    private LocalDateTime regDate;
    private Long replyCount;
}
