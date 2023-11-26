package com.example.mentoring_project.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardListReplyCountDTO {
    private int boardNo;
    private String id;
    private String nickName;
    private String title;
    private String content;
    private LocalDateTime addDate;
    private Integer hit;
    private String fileNames;
    private Long replyCount;

}
