package com.example.mentoring_project.mapper.qBoardMapper;

import com.example.mentoring_project.domain.qBoardVO.QBoardVO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface QBoardMapper {

    void insert(QBoardVO qBoardVO); //게시글 생성 메서드

    QBoardVO modify(Long qBoardVO); //게시글 수정 메서드

    void delete(QBoardVO qBoardVO);

    void deleteOne(Long qBoardVO);

    void update(QBoardVO qBoardVO); // 수정

    QBoardVO selectOne(Long qBoardNo); //게시글 하나 선택해서 읽기

    List<QBoardVO> selectAll();

    void updateHit(Long qBoardNo);

    List<QBoardVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);


}
