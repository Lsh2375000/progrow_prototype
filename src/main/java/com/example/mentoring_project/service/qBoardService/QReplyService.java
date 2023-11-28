package com.example.mentoring_project.service.qBoardService;

import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QReplyDTO;

public interface QReplyService {
    Long addReplyQ(QReplyDTO qReplyDTO);

//    Long registerReQ(QReplyDTO qReplyDTO);

    QReplyDTO read(Long qRno);
    void modifyOne(QReplyDTO qReplyDTO);
    void removeOne(Long qRno);
    PageResponseDTO<QReplyDTO> getListOfBoardQ(Long qBoardNo, PageRequestDTO pageRequestDTO);
}
