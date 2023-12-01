package com.example.mentoring_project.dto.qBoardDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QBoardDTO {
    private Long qnaBoardNo; // 게시글 No
    private String id; // ID
    private Integer hit; // 조회수
    private String nickname; // 닉네임
    private String content; // 게시글 내용
    private String title; // 게시글 제목

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate; // 게시글 작성일자

    @JsonIgnore
    private LocalDateTime modDate; // 게시글 수정일자


}
