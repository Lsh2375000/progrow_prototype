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
public class QBoardVO {
    private Long qnaBoardNo; // 게시글 No
    private String id; // ID
    private Integer hit; // 조회수
    private String nickName; // 닉네임
    private String content; // 게시글 내용
    private String title; // 게시글 제목

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate; // 리플 작성일자

    @JsonIgnore
    private LocalDateTime modDate; // 리플 수정일자

    public void change(String title, String content, String nickName) { // 게시글 변경 시 메서드
        this.title = title;
        this.content = content;
        this.nickName = nickName;
    }

}
