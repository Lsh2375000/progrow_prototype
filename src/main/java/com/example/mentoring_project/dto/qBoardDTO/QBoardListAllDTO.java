package com.example.mentoring_project.dto.qBoardDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QBoardListAllDTO {
    private Long qnaBoardNo;
    private String title;
    private String content;
    private String nickname;
    private Integer hit; // 조회수
    private LocalDateTime regDate;
    private Long qReplyCount;
    private List<QBoardImageDTO> qBoardImages;
}
