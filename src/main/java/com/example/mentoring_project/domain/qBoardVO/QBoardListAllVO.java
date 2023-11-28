package com.example.mentoring_project.domain.qBoardVO;

import com.example.mentoring_project.dto.qBoardDTO.QBoardImageDTO;
import lombok.Data;

import java.util.List;

@Data
public class QBoardListAllVO {
    private Long qnaBoardNo; // 게시글 No
    private String id; // ID
    private Integer hit; // 조회수
    private String nickName; // 닉네임
    private String content; // 게시글 내용
    private String title; // 게시글 제목

    private String regDate; // 등록일

    private int qReplyCount; // 댓글 수
    private List<QBoardImageDTO> qBoardImages; // 이미지
}
