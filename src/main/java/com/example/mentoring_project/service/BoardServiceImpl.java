package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardServiceImpl implements BoardService {
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;



    @Override
    public Long register(BoardDTO boardDTO) {
        log.info(boardDTO);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        Long boardNo = boardVO.getBoardNo();
        log.info("register...");
        boardMapper.save(boardVO);
        return boardNo;
    }

    /*게시물 전체 삭제*/
    @Override
    public void delete(Long boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);

        boardMapper.delete(boardVO);
    }


    /*게시물 하나 선택해서 삭제*/
    @Override
    public void deleteOne(Long boardNo) {
        boardMapper.deleteOne(boardNo);
    }

    @Override
    public BoardDTO selectOne(Long boardNo) {
        Optional<BoardVO> optionalBoardVO = boardMapper.selectOne(boardNo);
        BoardVO boardVO = optionalBoardVO.orElseThrow();
        return modelMapper.map(boardVO, BoardDTO.class);
    }


    @Override
    public void modify(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardVO.change(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getWriter());
        boardMapper.modify(boardVO);

    }

    @Override
    public BoardDTO readOne(Long boardNo) {

        return null;
    }

    //목록 가져오기
    @Override
    public List<BoardDTO> getAll() {
        List<BoardVO> boardVOList = boardMapper.selectAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardVOList.forEach(boardVO -> boardDTOList.add(modelMapper.map(boardVO, BoardDTO.class)));
        return boardDTOList;
    }

    @Override
    public int getCount(PageRequestDTO pageRequestDTO) {
        return 0;
    }

    /*페이징 기능*/
    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
       List<BoardVO> boardVOList = boardMapper.selectList(pageRequestDTO);
        List<BoardDTO> boardDTOList = new ArrayList<>();
       boardVOList.forEach(boardVO -> boardDTOList.add(modelMapper.map(boardVO, BoardDTO.class)));

       int total = boardMapper.getCount(pageRequestDTO);


        PageResponseDTO<BoardDTO> pageResponseDTO = PageResponseDTO.<BoardDTO>withAll()
                .dtoList(boardDTOList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    /*페이징*/



}
