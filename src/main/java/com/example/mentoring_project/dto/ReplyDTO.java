package com.example.mentoring_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private Long rno; //리플 고유 번호
    @NotNull
    private Long boardNo; //게시판의 글 고유번호

    @NotEmpty
    private String replyText; //리플의 내용

    @NotEmpty
    private String replyWriter; //리플 작성자

}
