package com.example.mentoring_project.service.qBoardService;

import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QBoardDTO;

import java.util.List;


public interface QBoardService {

    void getAll(QBoardDTO qBoardDTO); //게시판 데이터 불러오기

    void add(QBoardDTO qBoardDTO); //게시글 추가

    void delete(Long qBoardNo); //게시글 전체 삭제

    void deleteOne(Long qBoardNo); //게시글 하나 선택해서 삭제

    QBoardDTO selectOne(Long qBoardNo); //게시물 하나 선택해서 읽음

    void modify(QBoardDTO qBoardDTO); // 게시글 수정

    List<QBoardDTO> getAll();

    QBoardDTO getOne(Long qBoardNo, String view);

    PageResponseDTO<QBoardDTO> getList(PageRequestDTO pageRequestDTO);



}
