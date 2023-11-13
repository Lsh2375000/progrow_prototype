package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardDTO;

import java.util.List;


public interface BoardService {

    void getAll(BoardDTO boardDTO); //게시판 데이터 불러오기

    void add(BoardDTO boardDTO); //게시글 추가

    void delete(Long boardNo); //게시글 전체 삭제

    void deleteOne(Long boardNo); //게시글 하나 선택해서 삭제

    void selectOne(Long boardNo); //게시물 하나 선택해서 읽음

    void modify(BoardDTO boardDTO); // 게시글 수정


    List<BoardDTO> getAll();
}
