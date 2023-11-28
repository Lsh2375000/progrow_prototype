package com.example.mentoring_project.domain.boardVO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardVO {
    private Integer boardNo;
    private String id;
    private String nickname;
    private String title;
    private String content;
    private Integer hit;
    private LocalDateTime addDate;
    private String fileNames;

    @Override
    public String toString() {
        return "BoardVO{" +
                "boardNo=" + boardNo +
                ", id='" + id + '\'' +
                ", nickName='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", addDate=" + addDate +
                ", fileNames='" + fileNames + '\'' +
                '}';
    }
}
