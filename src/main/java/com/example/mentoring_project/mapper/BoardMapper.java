package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface BoardMapper {

    void insert(BoardVO boardVO); //게시글 생성 메서드

    Optional<BoardVO> modify(Long boardVO); //게시글 수정 메서드

    void delete(BoardVO boardVO);

    Optional<BoardVO> selectOne(Long boardNo); //게시글 하나 선택해서 읽기

    List<BoardVO> selectAll();


}
