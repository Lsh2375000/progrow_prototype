package com.example.mentoring_project.service.boardService;

import com.example.mentoring_project.dto.*;
import com.example.mentoring_project.dto.boardDTO.BoardDTO;
import com.example.mentoring_project.dto.boardDTO.BoardListReplyCountDTO;


public interface BoardService {

//    void add(BoardDTO boardDTO, List<MultipartFile> files); // 게시글 업로드
    void add(BoardDTO boardDTO); // 게시글 업로드

    void save(ImageDTO imageDTO);

    void removeOne(int boardNo); //게시글 하나 선택해서 삭제

    BoardDTO selectOne(int boardNo, String mode); //게시물 하나 선택해서 읽음

    void modify(BoardDTO boardDTO); // 게시글 수정

    int getCount(PageRequestDTO pageRequestDTO); //페이징


    PageResponseDTO<BoardListReplyCountDTO> getList(PageRequestDTO pageRequestDTO);

}
