package com.example.mentoring_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListAllDTO {
    private Long boardNo;
    private String title;
    private String writer;
    private Long replyCount;
    private List<BoardImageDTO> boardImages;
}
