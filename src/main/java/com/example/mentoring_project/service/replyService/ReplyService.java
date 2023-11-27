package com.example.mentoring_project.service.replyService;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.ReplyDTO;

public interface ReplyService {

    Long register(ReplyDTO replyDTO); //댓글 추가

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    //페이지 별 리플 목록
    PageResponseDTO<ReplyDTO> getList(int boardNo, PageRequestDTO pageRequestDTO);

    int getCount(int boardNo); //전체 리플 갯수




}
