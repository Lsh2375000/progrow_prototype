package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.ReplyDTO;

public interface ReplyService {

    Long insertReply(ReplyDTO replyDTO); //댓글 추가

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long boardNo, PageRequestDTO pageRequestDTO);





}
