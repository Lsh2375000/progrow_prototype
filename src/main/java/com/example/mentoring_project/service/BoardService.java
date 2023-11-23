package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.*;

import java.util.List;
import java.util.stream.Collectors;


public interface BoardService {

    Long register(BoardDTO boardDTO); // 게시글 업로드

    void delete(Long boardNo); //게시글 전체 삭제

    void deleteOne(Long boardNo); //게시글 하나 선택해서 삭제

    BoardDTO selectOne(Long boardNo); //게시물 하나 선택해서 읽음

    void modify(BoardDTO boardDTO); // 게시글 수정

    int getCount(PageRequestDTO pageRequestDTO); //페이징


    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO); //list()라는 이름으로 목록/ 검색 기능

    /*BoardService에 BoardListAllDTO를 이용할 수 있도록 listWithAll() 메서드 추가*/
    PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO);

    default BoardVO dtoToEntity(BoardDTO boardDTO){
        BoardVO boardVO = BoardVO.builder()
                .boardNo(boardDTO.getBoardNo())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .build();

        if (boardDTO.getFileNames() != null){
            boardDTO.getFileNames().forEach(fileName ->{
                String[] arr = fileName.split("_");
                boardVO.addImage(arr[0], arr[1]);
            });
        }
        return boardVO;
    }


    default BoardDTO dtoToEntity(BoardVO boardVO){
        //엔티티 객체를 DTO로 변환
        BoardDTO boardDTO = BoardDTO.builder()
                .boardNo(boardVO.getBoardNo())
                .title(boardVO.getTitle())
                .content(boardVO.getContent())
                .writer(boardVO.getWriter())
                .build();

        //엔티티 객체의 imageSet(Set<BoardImage> 타입)에서 uuid와 fileName을 조합해서 문자열 리스트(List<string>)로 반환.
        List<String> fileNames = boardVO.getImageVOSet().stream().sorted().map(boardImageVO ->
                boardImageVO.getUuid() + "_" + boardImageVO.getFileName()).collect(Collectors.toList());
        boardDTO.setFileNames(fileNames);
        return boardDTO;
    }
}
