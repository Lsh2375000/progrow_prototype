package com.example.mentoring_project.dto.replyDTO;

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
    private String content; //리플의 내용
    private String nickname; //리플 작성자
    private Long boardNo; //게시판의 글 고유번호

}
