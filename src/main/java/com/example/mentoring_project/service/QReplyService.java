package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.QReplyDTO;

public interface QReplyService {
    Long addReplyQ(QReplyDTO qReplyDTO);

//    Long registerReQ(QReplyDTO qReplyDTO);

    QReplyDTO read(Long qRno);
    void modifyOne(QReplyDTO qReplyDTO);
    void removeOne(Long qRno);
    PageResponseDTO<QReplyDTO> getListOfBoardQ(Long qBoardNo, PageRequestDTO pageRequestDTO);
}
