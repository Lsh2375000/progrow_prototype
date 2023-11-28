package com.example.mentoring_project.mapper.qBoardMapper;


import com.example.mentoring_project.domain.qBoardVO.QReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface QReplyMapper {

    void insertQR(QReplyVO qReplyVO);
    QReplyVO selectOneQR(Long qRno);
    void updateQR(QReplyVO qReplyVO);
    void deleteQR(Long qRno);
    List<QReplyVO> selectListOfBoardQR(@Param("qBoardNo") Long qBoardNo, @Param("skip") int skip, @Param("size") int size);
    int getCountQR(Long qBoardNo);


}
