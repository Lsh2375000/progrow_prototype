package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.BoardListAllDTO;
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
        BoardVO boardVO1 = dtoToEntity(boardDTO);
        Long boardNo = boardDTO.getBoardNo();
        log.info("register...");
        boardMapper.save(boardVO);
        boardMapper.register(boardVO1);
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
        BoardVO boardVO = boardMapper.selectOne(boardNo);
        BoardDTO boardDTO = dtoToEntity(boardVO);
        return boardDTO;
    }


    @Override
    public void modify(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardVO.change(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getWriter());

        //첨부파일의 처리
        //1. 기존 정보 삭제
        boardVO.clearImages();

        //2. 기존파일, 새로 추가된 파일을 등록
        if (boardDTO.getFileNames() != null){
            for(String fileName : boardDTO.getFileNames()){
                String[] arr = fileName.split("_");
                boardVO.addImage(arr[0], arr[1]);
            }
        }
        boardMapper.modify(boardVO);

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

   @Override
    public PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO){
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();




        return PageResponseDTO.<BoardListAllDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .build();
   }



}
