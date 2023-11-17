package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.QBoardVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface QBoardMapper {

    void insert(QBoardVO qBoardVO); //게시글 생성 메서드

    Optional<QBoardVO> modify(Long qBoardVO); //게시글 수정 메서드

    void delete(Long qBoardVO);

    Optional<QBoardVO> selectOne(Long qBoardNo); //게시글 하나 선택해서 읽기

    List<QBoardVO> selectAll();

    void updateHit(Long qBoardNo);

    List<QBoardVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
