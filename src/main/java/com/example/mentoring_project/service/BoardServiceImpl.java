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
    public void add(BoardDTO boardDTO) {
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
    public void deleteOne(Long boardDTO) {

    }

    @Override
    public BoardDTO selectOne(Long boardNo) {
        Optional<BoardVO> optionalBoardVO = boardMapper.selectOne(boardNo);
        BoardVO boardVO = optionalBoardVO.orElseThrow();
        return modelMapper.map(boardVO, BoardDTO.class);
    }


    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<BoardVO> result = boardMapper.modify(boardDTO.getBoardNo());
        BoardVO boardVO = result.orElseThrow();
        boardVO.change(boardVO.getTitle(), boardVO.getContent());
        boardMapper.modify(boardVO.getBoardNo());

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

    /*검색 기능*/
    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();

       List<BoardVO> boardVOList = boardMapper.list(pageRequestDTO);
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardVO boardVO : boardVOList){
            boardDTOList.add(modelMapper.map(boardVO, BoardDTO.class));
        }
        int total = 0;
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(boardDTOList)
                .total(total)
                .build();
    }


}
