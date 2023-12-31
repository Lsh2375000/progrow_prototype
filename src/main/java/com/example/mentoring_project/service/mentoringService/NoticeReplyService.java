package com.example.mentoring_project.service.mentoringService;

import com.example.mentoring_project.dto.mentoringDTO.NoticeReplyDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;

import java.util.List;

public interface NoticeReplyService {

    Long register(NoticeReplyDTO noticeReplyDTO);

    // 제발..

    NoticeReplyDTO read(Long rno);

    void modify(NoticeReplyDTO noticeReplyDTO);

    void remove(Long rno);

    PageResponseDTO<NoticeReplyDTO> getList(int num, PageRequestDTO pageRequestDTO); // 페이지 별 리플 목록

    int getCount(int num); // 전체 리플 갯수




    List<NoticeReplyDTO> getAllList(Long num); // 안씀

}
