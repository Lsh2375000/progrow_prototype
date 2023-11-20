package com.example.mentoring_project.dto;

import lombok.Data;

@Data
public class BoardListReplyCountDTO {
    private Long boardNo;
    private String title;
    private String writer;
    private Long replyCount;
}
