package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    
    void register(BoardVO boardVO); //게시글 생성 메서드


    void delete(BoardVO boardVO);

    void deleteOne(Long boardVO);


    BoardVO selectOne(Long boarNo);

   Long save(BoardVO boardVO);

    void modify(BoardVO boardVO);

    void count(BoardVO boardVO); //게시물 총 갯수

     int getCount(PageRequestDTO pageRequestDTO); //페이징
    List<BoardVO> getList(PageRequestDTO pageRequestDTO);

    List<BoardVO> selectList(PageRequestDTO pageRequestDTO);

}
