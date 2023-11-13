package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.BoardDTO;
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
public class BoardServiceImpl implements BoardService{
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public void getAll(BoardDTO boardDTO) {
        BoardDTO boardDTO1 = modelMapper.map(boardDTO, BoardDTO.class);

    }

    @Override
    public void add(BoardDTO boardDTO){
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);

        boardMapper.insert(boardVO);
    }

    @Override
    public void delete(Long boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);

        boardMapper.delete(boardVO);
    }

    /*게시물 하나 선택해서 삭제*/
    @Override
    public void deleteOne(Long boardDTO){

    }

    @Override
    public void selectOne(Long boardNo){
        Optional<BoardVO> optionalBoardVO = boardMapper.selectOne(boardNo);
        BoardVO boardVO = optionalBoardVO.orElseThrow();
        BoardDTO  boardDTO = new BoardDTO();

    }

    @Override
    public void modify(BoardDTO boardDTO){
        Optional<BoardVO> optionalBoardVO = boardMapper.modify(boardDTO.getBoardNo());
        BoardVO boardVO = optionalBoardVO.orElseThrow();
        boardVO.change(boardVO.getTitle(), boardVO.getContent());
        boardMapper.modify(boardVO.getBoardNo());

    }

    @Override
    public List<BoardDTO> getAll() {
        List<BoardVO> boardVOList = boardMapper.selectAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardVOList.forEach(boardVO -> boardDTOList.add(modelMapper.map(boardVO, BoardDTO.class)));
        return boardDTOList;
    }


}
