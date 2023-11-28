package com.example.mentoring_project.domain.qBoardVO;

import lombok.*;

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

    private String regDate; // 등록일
    private String modDate; // 수정일

    public void change(String title, String content, String nickName) { // 게시글 변경 시 메서드
        this.title = title;
        this.content = content;
        this.nickName = nickName;
    }

}