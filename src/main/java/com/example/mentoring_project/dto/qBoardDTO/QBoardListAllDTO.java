package com.example.mentoring_project.dto.qBoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QBoardListAllDTO {
    private Long qBoardNo;
    private String title;
    private String writer;
    private LocalDateTime regDate;
    private Long replyCount;
    private List<QBoardImageDTO> qBoardImages;
}
