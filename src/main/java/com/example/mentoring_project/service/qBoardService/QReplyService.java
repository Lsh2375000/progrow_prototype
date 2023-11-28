package com.example.mentoring_project.service.qBoardService;

import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QReplyDTO;

public interface QReplyService {

    Long addReplyQ(QReplyDTO qReplyDTO); // Qna 댓글 등록

//    Long registerReQ(QReplyDTO qReplyDTO); // Qna 답글(대댓글) 등록

    QReplyDTO read(Long qnaRno); // 특정 Qna 댓글 조회
    void modifyOne(QReplyDTO qReplyDTO); // 특정 Qna 댓글 수정
    void removeOne(Long qnaRno); // 특정 Qna 댓글 삭제
    // Qna 댓글 리스트 조회
    PageResponseDTO<QReplyDTO> getListOfBoardQR(long qnaBoardNo, PageRequestDTO pageRequestDTO);

}
