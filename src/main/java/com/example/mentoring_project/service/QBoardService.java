package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.QBoardDTO;

import java.util.List;


public interface QBoardService {

    void getAll(QBoardDTO qBoardDTO); //게시판 데이터 불러오기

    void add(QBoardDTO qBoardDTO); //게시글 추가

    void delete(Long qBoardNo); //게시글 전체 삭제

    void deleteOne(Long qBoardNo); //게시글 하나 선택해서 삭제

    void selectOne(Long qBoardNo); //게시물 하나 선택해서 읽음

    void modify(QBoardDTO qBoardDTO); // 게시글 수정


    List<QBoardDTO> getAll();
}
