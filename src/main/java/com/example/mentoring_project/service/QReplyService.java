package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.QReplyDTO;

public interface QReplyService {
    Long register(QReplyDTO qReplyDTO);

//    Long registerReQ(QReplyDTO qReplyDTO);

    QReplyDTO read(Long qRno);
    void modify(QReplyDTO qReplyDTO);
    void remove(Long qRno);
    PageResponseDTO<QReplyDTO> getListOfBoard(Long qBoardNo, PageRequestDTO pageRequestDTO);
}
