package com.example.mentoring_project.mapper.boardMapper;

import com.example.mentoring_project.domain.boardVO.BoardVO;
import com.example.mentoring_project.dto.boardDTO.BoardListReplyCountDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    String getTime();

    void insert(BoardVO boardVO); //게시글 생성 메서드

    void removeOne(int boardVO);

    BoardVO selectOne(int boarNo);

    void modify(BoardVO boardVO);


    void count(BoardVO boardVO); //게시물 총 갯수

     int getCount(PageRequestDTO pageRequestDTO);

    List<BoardListReplyCountDTO> selectList(PageRequestDTO pageRequestDTO);

    int hit(int boardNo);

}
