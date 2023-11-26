package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.domain.ImageVO;
import com.example.mentoring_project.dto.*;
import com.example.mentoring_project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    @Value("${com.example.upload.path}")
    private String uploadPath;


    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;


    @Override
    public void add(BoardDTO boardDTO) {
        log.info(boardDTO);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        log.info("boardVO: " + boardVO);
        boardMapper.insert(boardVO);
    }

    @Override
    public void save(ImageDTO imageDTO) {
        log.info(imageDTO);
        ImageVO imageVO = modelMapper.map(imageDTO, ImageVO.class);
        boardMapper.save(imageDTO);
        log.info(imageVO);
    }


    /*게시물 하나 선택해서 삭제*/
    @Override
    public void removeOne(int boardNo) {
        boardMapper.removeOne(boardNo);
    }

    @Override
    public BoardDTO selectOne(int boardNo, String mode) {
        BoardVO boardVO = boardMapper.selectOne(boardNo);
        boardMapper.hit(boardNo);
        BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);
        return boardDTO;
    }


    @Override
    public void modify(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardMapper.modify(boardVO);
     }

    @Override
    public int getCount(PageRequestDTO pageRequestDTO) {
        return 0;
    }

    /*페이징 기능*/
    @Override
    public PageResponseDTO<BoardListReplyCountDTO> getList(PageRequestDTO pageRequestDTO) {
        String[] types=pageRequestDTO.getTypes();
        String keyword=pageRequestDTO.getKeyword();

        List<BoardListReplyCountDTO> dtoList = boardMapper.selectList(pageRequestDTO);
        List<BoardDTO> boardDTOList = new ArrayList<>();

       int total = boardMapper.getCount(pageRequestDTO);




        return PageResponseDTO.<BoardListReplyCountDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO).build();
    }





}
