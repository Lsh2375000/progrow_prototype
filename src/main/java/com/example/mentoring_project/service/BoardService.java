package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;

import java.util.List;


public interface BoardService {

    void add(BoardDTO boardDTO); //게시글 추가

    void delete(Long boardNo); //게시글 전체 삭제

    void deleteOne(Long boardNo); //게시글 하나 선택해서 삭제

    BoardDTO selectOne(Long boardNo); //게시물 하나 선택해서 읽음

    void modify(BoardDTO boardDTO); // 게시글 수정

    BoardDTO readOne(Long boardNo); //게시물 하나 선택해서 읽음

    List<BoardDTO> getAll(); //게시글 목록 불러옴

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO); //list()라는 이름으로 목록/ 검색 기능




}
