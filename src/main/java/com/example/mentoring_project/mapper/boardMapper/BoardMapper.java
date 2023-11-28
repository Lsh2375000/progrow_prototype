package com.example.mentoring_project.mapper.boardMapper;

import com.example.mentoring_project.domain.boardVO.BoardVO;
import com.example.mentoring_project.dto.ImageDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.boardDTO.BoardListReplyCountDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    String getTime();

    void insert(BoardVO boardVO); //게시글 생성 메서드

    void removeOne(int boardVO);

    BoardVO selectOne(int boarNo);

    void modify(BoardVO boardVO);

    void save(ImageDTO imageDTO); //이미지 저장

    void count(BoardVO boardVO); //게시물 총 갯수

     int getCount(PageRequestDTO pageRequestDTO);

    List<BoardListReplyCountDTO> selectList(PageRequestDTO pageRequestDTO);

    int hit(int boardNo);

}
