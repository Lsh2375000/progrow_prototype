package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface BoardMapper {

    void insert(BoardVO boardVO); //게시글 생성 메서드

    Optional<BoardVO> modify(Long boardVO); //게시글 수정 메서드

    void delete(BoardVO boardVO);

    List<BoardVO> selectAll();

    List<BoardVO> list(PageRequestDTO pageRequestDTO); // 검색 매핑

    Optional<BoardVO> selectOne(Long boarNo);

//    int getCount(PageRequestDTO pageRequestDTO);


}
